package com.hencoder.plus.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;

/**
 * @author : dev
 * @version :
 * @Date :  2021/7/19 15:25
 * @Desc :
 */
public class SomeView extends ViewGroup {
    public SomeView(Context context) {
        super(context);
    }

    public SomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SomeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SomeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            LayoutParams lp = childView.getLayoutParams();

            // (measureSpec & MODE_MASK);
            int widthMode = MeasureSpec.getMode(widthMeasureSpec);
            // (measureSpec & ~MODE_MASK);
            int widthSize = MeasureSpec.getSize(widthMeasureSpec);
            int usedWidth = 10;
            int childWidthSpec;

            switch (lp.width) {
                case LayoutParams.MATCH_PARENT:
                    if (widthMode == MeasureSpec.EXACTLY || widthMode == MeasureSpec.AT_MOST) {
                        childWidthSpec = MeasureSpec.makeMeasureSpec(widthSize - usedWidth, MeasureSpec.AT_MOST);
                    } else {
                        // 不确定大小模式
                        childWidthSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    }

                case LayoutParams.WRAP_CONTENT:
                    if (widthMode == MeasureSpec.EXACTLY || widthMode == MeasureSpec.AT_MOST) {
                        childWidthSpec = MeasureSpec.makeMeasureSpec(widthSize - usedWidth, MeasureSpec.AT_MOST);
                    } else {
                        childWidthSpec = MeasureSpec.makeMeasureSpec(widthSize - usedWidth, MeasureSpec.UNSPECIFIED);
                    }
                default:
                    childWidthSpec = MeasureSpec.makeMeasureSpec(lp.width, MeasureSpec.EXACTLY);
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


}
