package com.github.frameworkbinder_server;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Process;

import androidx.annotation.Nullable;

import com.github.frameworkbinder_server.diy.Stub;

/**
 * @author : dev
 * @version :
 * @Date :  2022/9/6 12:23
 * @Desc :
 */
public class RemoteService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final Stub binder = new Stub() {

        @Override
        public int getPid() throws RemoteException {
            return Process.myPid();
        }
    };


    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return "很遗憾，没有获取到进程名称！";
    }

}
