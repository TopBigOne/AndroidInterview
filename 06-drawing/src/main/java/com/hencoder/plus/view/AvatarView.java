package com.hencoder.plus.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.hencoder.plus.R;
import com.hencoder.plus.Utils;

import java.util.Map;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-11 13:42
 * @Desc :
 */
public class AvatarView extends View {
    private static final float WIDTH      = Utils.dp2px(300);
    private static final float PADDING    = Utils.dp2px(50);
    private static final float EDGE_WIDTH = Utils.dp2px(10);

    // 留意这个类
    Paint    mPaint    = new Paint(Paint.ANTI_ALIAS_FLAG);
    Xfermode mXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

    Bitmap mBitmap;
    RectF  mSaveArea = new RectF();

    public AvatarView(Context context) {
        super(context);
    }

    public AvatarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AvatarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    {
        mBitmap = getAvatar((int) WIDTH);
    }

    private Bitmap getAvatar(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.li_jie, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(getResources(), R.mipmap.li_jie, options);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 画一个椭圆
        canvas.drawOval(PADDING, PADDING, PADDING + WIDTH, PADDING + WIDTH, mPaint);
        int saved = canvas.saveLayer(mSaveArea, mPaint);
        canvas.drawOval(PADDING + EDGE_WIDTH, PADDING + EDGE_WIDTH, PADDING + WIDTH - EDGE_WIDTH, PADDING + WIDTH - EDGE_WIDTH, mPaint);
        mPaint.setXfermode(mXfermode);
        canvas.drawBitmap(mBitmap, PADDING, PADDING, mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(saved);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mSaveArea.set(PADDING, PADDING, PADDING + WIDTH, PADDING + WIDTH);
    }
}
