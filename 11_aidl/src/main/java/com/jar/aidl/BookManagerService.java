package com.jar.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author : dev
 * @version :
 * @Date :  2021/7/28 14:50
 * @Desc :
 */
public class BookManagerService  extends Service {
    private static final String TAG = "BMS";

    private AtomicBoolean mIsServiceDestoryed = new AtomicBoolean(false);
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
