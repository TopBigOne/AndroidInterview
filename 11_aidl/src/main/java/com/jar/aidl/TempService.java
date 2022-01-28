package com.jar.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author : dev
 * @version :
 * @Date :  2021/7/28 14:50
 * @Desc :
 */
public class TempService extends Service {
    private static final String TAG = "TempService : ";

    private RemoteCallbackList<IMsgArrivedListener> mListenerList = new RemoteCallbackList<>();


    IBinder mBinder = new IMsgManager.Stub() {

        @Override
        public IBinder asBinder() {
            return super.asBinder();
        }


        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {

            return super.onTransact(code, data, reply, flags);
        }

        @Override
        public void send(String msg) throws RemoteException {
        }
    };


    @Override
    public void onCreate() {
        super.onCreate();
        // 启动服务
        new Thread(new ServiceWorker()).start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    private class ServiceWorker implements Runnable {
        @Override
        public void run() {

        }
    }

}

}
