package com.david.a21_test_breakpad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2024/7/26 12:41
 * @Desc :
 */
public class JniCrashMonitor {
    private static final String TAG = "JniCrashMonitor";
    private Context mContext;
    private String mPath;
    private ICrashCallback mCallback;


    // Used to load the 'test_breakpad' library on application startup.
    static {
        System.loadLibrary("test_breakpad");
    }


    /**
     * 带日志存储路径
     *
     * @param context
     * @param path
     */
    public void init(Context context, String path, ICrashCallback callback) {
        mPath = path;
        mCallback = callback;
        init(context);
    }

    /**
     * 默认存储路径
     *
     * @param context
     */
    public void init(Context context) {
        mContext = context;
        if (TextUtils.isEmpty(mPath)) {
            mPath = mContext.getCacheDir().getPath();
        }
        init(mPath);
    }

    /**
     * 初始化，传入存放文件的目录
     */
    private native void init(String path);

    /**
     * 测试本地崩溃
     */
    public native void testNativeCrash();

    /**
     * ndk回调
     * @param path
     */
    public void callback(String path) {

        Log.e(TAG, "callback: " );

    }

}
