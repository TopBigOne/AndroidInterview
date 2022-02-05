package com.jar.native_ya;

public class NativeLib {

    // Used to load the 'native_lib_tip_ip' library on application startup.
    static {
        System.loadLibrary("native_lib_tip_ip");
    }

    /**
     * A native method that is implemented by the 'native_lib_tip_ip' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}