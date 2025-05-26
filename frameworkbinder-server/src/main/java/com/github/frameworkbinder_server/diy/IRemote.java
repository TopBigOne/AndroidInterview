package com.github.frameworkbinder_server.diy;

import android.os.IInterface;

/**
 * @author : dev
 * @version :
 * @Date :  2022/9/6 12:26
 * @Desc :
 */
public interface IRemote extends IInterface {

    public static final java.lang.String DESCRIPTOR = "com.github.frameworkbinder_server.diy.IRemote";
    public static final int TRANSACTION_getPid = (android.os.IBinder.FIRST_CALL_TRANSACTION);

    public int getPid() throws android.os.RemoteException;

}
