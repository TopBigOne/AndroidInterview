package com.jar.ya;

public class NativeLib {

    // Used to load the 'ya' library on application startup.
    static {
        System.loadLibrary("ya");
    }

    /**
     * A native method that is implemented by the 'ya' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    /**
     * 最长递增子序列
     * @param nums
     * @return
     */
    public native int  nativeLcs(int [] nums);
}