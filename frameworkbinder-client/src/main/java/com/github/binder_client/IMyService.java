package com.github.binder_client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/**
 * @author : dev
 * @version :
 * @Date :  12/20/20 10:40 PM
 * @Desc :
 */
public interface IMyService extends IInterface {
    String DESCRIPTOR = "com.github.binder_client.MyServer";

    void sayHello(String str) throws RemoteException;

    int TRANSACTION_say = IBinder.FIRST_CALL_TRANSACTION;
}
