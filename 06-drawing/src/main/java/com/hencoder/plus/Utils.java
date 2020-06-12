package com.hencoder.plus;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-11 13:42
 * @Desc :
 */
public class Utils {
    public static float dp2px(float dp) {
        // 这个 api 我没有用过。
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}
