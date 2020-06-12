package com.hencoder.plus.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.hencoder.plus.Utils;

import static com.hencoder.plus.Utils.dp2px;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-12 11:27
 * @Desc :
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class Dashboard extends View {
    private static final int   ANGLE  = 120;
    private static final float RADIUS = dp2px(150);
    private static final float LENGTH = dp2px(100);

    private Paint              mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path               mDash  = new Path();
    private PathDashPathEffect mEffect;

    public Dashboard(Context context) {
        super(context);
    }

    public Dashboard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Dashboard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dp2px(2));
        mDash.addRect(0, 0, dp2px(2), dp2px(10), Path.Direction.CW);

        Path arc = new Path();
        // 强大的位运算。
        arc.addArc((getWidth() >> 1) - RADIUS, (getHeight() >> 1) - RADIUS,
                (getWidth() >> 1) + RADIUS, (getHeight() >> 1) + RADIUS,
                90 + ANGLE / 2, 360 - ANGLE);


        PathMeasure pathMeasure = new PathMeasure();
        mEffect = new PathDashPathEffect(mDash, (pathMeasure.getLength() - Utils.dp2px(2)) / 2,
                0, PathDashPathEffect.Style.ROTATE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 画线
        canvas.drawArc((getWidth() >> 1) - RADIUS,
                (getHeight() >> 1) - RADIUS,
                (getWidth() >> 1) + RADIUS,
                (getHeight() >> 1) + RADIUS,
                90 + ANGLE / 2,
                360 - ANGLE,
                false, mPaint);

        // 画刻度
        mPaint.setPathEffect(mEffect);
        canvas.drawArc((getWidth() >> 1) - RADIUS, (getHeight() >> 1) - RADIUS,
                (getWidth() >> 1) + RADIUS, (getHeight() >> 1) + RADIUS,
                90 + ANGLE >> 1, 360 - ANGLE,
                false, mPaint);
        // 话指针
        canvas.drawLine((getWidth() >> 1), (getHeight() >> 1),
                (float) Math.cos(Math.toRadians(getAngleFromMark(5))) * LENGTH + (getWidth() >> 1),
                (float) Math.sin(Math.toRadians(getAngleFromMark(5))) * LENGTH + (getHeight() >> 1)
                , mPaint);


    }

    private int getAngleFromMark(int mark) {
        return (90 + (ANGLE >> 1) + ((360 - ANGLE) / 20) * mark);
    }
}
