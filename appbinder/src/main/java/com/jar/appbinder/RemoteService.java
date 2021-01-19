package com.jar.appbinder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * @author : dev
 * @version :
 * @Date :  12/20/20 5:29 PM
 * @Desc :
 */
public class RemoteService extends Service {
    private static final String TAG = "Simple RemoteService: ";
    private MyData mMyData;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");
        initMyData();
    }

    private void initMyData() {
        mMyData = new MyData();
        mMyData.setData1(10);
        mMyData.setData2(20);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {


        @Override
        public int getPid() throws RemoteException {
            int pid = Process.myPid();
            Log.i(TAG, "getPid: = " + pid);
            return pid;
        }

        @Override
        public MyData getMyData() throws RemoteException {
            Log.d(TAG, "getMyData: "+mMyData);
            return mMyData;
        }

        /**
         * 此处可以用作权限拦截
         * @param code
         * @param data
         * @param reply
         * @param flags
         * @return
         * @throws RemoteException
         */
        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            return super.onTransact(code, data, reply, flags);
        }
    };
};
