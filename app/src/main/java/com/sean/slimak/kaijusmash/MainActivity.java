package com.sean.slimak.kaijusmash;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.app.Activity;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.Toast;


public class MainActivity extends Activity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private GestureDetector motionDect;
    private float x1, x2,y1,y2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildVars();

    }

    private void buildVars(){
     //   motionDect = new GestureDetectorCompat(this, this);
      //  motionDect.setOnDoubleTapListener(this);
    }

    @Override
    /*
    *  useful for the game I am working on need to be able to determine tap, and direction of a swipe
    *  for control purposes, not sure if this is enough of a view component though
     */
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        boolean ret = false;
        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                x1 = event.getX();
                y1 = event.getY();
               ret= true;
                break;
            case (MotionEvent.ACTION_MOVE):
                ret= true;
                break;
            case (MotionEvent.ACTION_UP):
                x2 = event.getX();
                y2 = event.getY();

                if (x1 < x2 || x2 > x1) {
                    Toast.makeText(this, "Horizontal Swipe", Toast.LENGTH_LONG).show();
                }

                if (y1 < y2 || y2 > y1) {
                    Toast.makeText(this, "Vertical Swipe", Toast.LENGTH_LONG).show();
                }

                if (x1==x2 && y1==y2){
                    Toast.makeText(this, "tap", Toast.LENGTH_LONG).show();
                }
                ret= true;
                break;
            case (MotionEvent.ACTION_CANCEL):
                ret= true;
                break;
            case (MotionEvent.ACTION_OUTSIDE):
                ret= true;
                break;
            default:
                return super.onTouchEvent(event);

        }
        return ret;
    }

    @Override
   /* public boolean onTouchEvent(MotionEvent event){
        this.motionDect.onTouchEvent(event);
        return super.onTouchEvent(event);
    }*/


    public boolean onDown(MotionEvent event) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    public boolean onFling(MotionEvent event) {
        return true;
    }


    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }
}
