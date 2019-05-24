package top.qvisa.myviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;
import android.widget.Toolbar;

import top.qvisa.myviewdemo.MyView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private MyView mMyView;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyView = findViewById(R.id.MyView);
        MyGestureListener mMyGestureListener = new MyGestureListener();
        mGestureDetector = new GestureDetector(this, mMyGestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                mMyView.setAlpha(0.5f);
                break;
            case MotionEvent.ACTION_UP:
                mMyView.setAlpha(1.0f);
                break;
        }
        return mGestureDetector.onTouchEvent(event);
    }

    private class MyGestureListener implements GestureDetector.OnGestureListener {

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            Log.d(TAG, "onDown:按下");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
            Log.d(TAG, "onShowPress:手指按下一段时间,不过还没到长按");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Log.d(TAG, "onSingleTapUp:手指离开屏幕的一瞬间");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.d(TAG, "onScroll:在触摸屏上滑动");
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            Log.d(TAG, "onLongPress:长按并且没有松开");
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            if(motionEvent.getY()-motionEvent1.getY()>30&&Math.abs(v1)>50){
                mMyView.setScaleX(1.1f);
                mMyView.setScaleY(1.1f);
                Log.d(TAG, "onFling:>>>>>>上滑<<<<<<,");
            }else if (motionEvent1.getY()-motionEvent.getY()>30&&Math.abs(v1)>50){
                mMyView.setScaleX(1.0f);
                mMyView.setScaleY(1.0f);
                Log.d(TAG, "onFling:>>>>>>下滑<<<<<<,");
            }
            Log.d(TAG, "onFling:迅速滑动，并松开");
            return false;
        }
    }
}
