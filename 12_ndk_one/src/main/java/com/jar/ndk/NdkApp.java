package com.jar.ndk;

import android.app.Application;
import android.content.Context;

import java.io.File;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2024/7/24 13:17
 * @Desc :
 */
public class NdkApp extends Application {

    private static NdkApp app = null;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        app = this;
        initLogDog();
    }

    public static NdkApp getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logdog.getInstance().i("NdkApp is create");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Logdog.getInstance().release();
    }

    private void initLogDog() {
        File file = new File(this.getExternalFilesDir(null), "logdog");
        String path = file.getAbsolutePath();
        Logdog.getInstance().init(path);
    }

}
