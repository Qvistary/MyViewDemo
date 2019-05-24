package top.qvisa.myviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    private Paint mPaint_Black;
    private Paint mPaint_Blue;
    private Paint mPaint_Red;
    private float[] mFloats = new float[]{570, 500, 410, 700, 410, 700, 730, 700, 730, 700, 570, 500};

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init_Paint();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(310, 350, 100, mPaint_Black);
        canvas.drawOval(720, 300, 910, 400, mPaint_Black);
        canvas.drawRect(150, 200, 990, 1000, mPaint_Blue);
        canvas.drawArc(310, 700, 830, 800, 0, 180, false, mPaint_Blue);
        canvas.drawRect(310, 850, 830, 950, mPaint_Red);
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
        mPaint_Blue.setAntiAlias(true);
        mPaint_Blue.setStrokeWidth(8f);

        mPaint_Red = new Paint();
        mPaint_Red.setColor(Color.RED);
        mPaint_Red.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint_Red.setAntiAlias(true);
    }
}
