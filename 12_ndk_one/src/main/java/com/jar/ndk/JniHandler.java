package com.jar.ndk;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;

import androidx.annotation.Keep;

/**
 * @author : dev
 * @version :
 * @Date :  12/13/21 11:31 AM
 * @Desc : https://blog.csdn.net/yuzhiqiang666/article/details/101124117
 */
public class JniHandler {
    /*
     * Print out status to logcat
     */
    @Keep
    private void updateStatus(String msg) {
        if (msg.toLowerCase().contains("error")) {
            Log.e("JniHandler", "Native Err: " + msg);
        } else {
            Log.i("JniHandler", "Native Msg: " + msg);
        }
    }

    /*
     * Return OS build version: a static function
     */
    @Keep
    static public String getBuildVersion() {
        return Build.VERSION.RELEASE;
    }

    /*
     * Return Java memory info
     */
    @Keep
    public long getRuntimeMemorySize() {
        return Runtime.getRuntime().freeMemory();
    }


   // public native Bitmap generateBitmap(String str, int[] datas);
    public native void generateBitmap(String str, int[] datas);
}
