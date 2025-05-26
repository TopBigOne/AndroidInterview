package com.github.frameworkbinder_server.diy;

import android.os.IBinder;
import android.os.RemoteException;

/**
 * @author : dev
 * @version :
 * @Date :  2022/9/6 12:38
 * @Desc :
 */
public class Proxy implements IRemote {

    private android.os.IBinder mRemote;

    Proxy(android.os.IBinder remote) {
        mRemote = remote;
    }


    @Override
    public int getPid() throws RemoteException {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result = 0;
        try {
            _data.writeInterfaceToken(DESCRIPTOR);
            // 注意这3个参数
            mRemote.transact(TRANSACTION_getPid, _data, _reply, 0);
            _reply.readException();
            _result = _reply.readInt();
        } finally {
            _data.recycle();
            _reply.recycle();
        }
        return _result;
    }

    public java.lang.String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override
    public IBinder asBinder() {
        return mRemote;
    }
}
