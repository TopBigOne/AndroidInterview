package com.android.interview.utils;

import android.content.Context;
import android.content.Intent;

/**
 * @author : dev
 * @version :
 * @Date :  7/10/21 2:44 PM
 * @Desc :
 */
public class Nav {
    public static void goActivity(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
