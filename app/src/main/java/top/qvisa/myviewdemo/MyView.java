package top.qvisa.myviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    private Paint mPaint_Black;
    private Paint mPaint_Blue;
    private float[] mFloats = new float[]{450,400,400,450};

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init_Paint();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(250, 250, 80, mPaint_Black);
        canvas.drawOval(480, 200, 700, 300, mPaint_Black);
        canvas.drawRect(100, 100, 800, 700, mPaint_Blue);
        canvas.drawLines(mFloats, mPaint_Blue);

    }

    private void init_Paint() {
        mPaint_Black = new Paint();
        mPaint_Black.setColor(Color.BLACK);
        mPaint_Black.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint_Black.setAntiAlias(true);

        mPaint_Blue = new Paint();
        mPaint_Blue.setColor(Color.BLUE);
        mPaint_Blue.setStyle(Paint.Style.STROKE);
        mPaint_Blue.setStrokeWidth(8f);
    }
}
