package com.hencoder.plus.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/10 14:06
 * @Url :
 * @Level : easy medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class TransView  extends ViewGroup {
    public TransView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TransView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TransView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }


    private  void testMeasure(){
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.height = LayoutParams.WRAP_CONTENT;
        // 一定要是wrap_content
        layoutParams.width = LayoutParams.WRAP_CONTENT;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = resolveSizeAndState(10000,widthMeasureSpec,0);
        setMeasuredDimension(width,MeasureSpec.getSize(heightMeasureSpec));
    }
}
