package com.github.frameworkbinder_server.diy;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * @author : dev
 * @version :
 * @Date :  2022/9/6 12:26
 * @Desc :
 */
public abstract class Stub extends android.os.Binder implements IRemote {
    public Stub() {
        this.attachInterface(this, DESCRIPTOR);
    }

    public static IRemote asInterface(android.os.IBinder obj) {
        if (obj == null) {
            return null;
        }
        // 用来查询本地接口的，有直接返回，没有就返回mull
        IInterface iInterface = obj.queryLocalInterface(DESCRIPTOR);
        if (((iInterface != null) && (iInterface instanceof IRemote))) {
            return (IRemote) iInterface;
        }
        // 是一个远程通信
        return new Proxy(obj);

    }

    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case INTERFACE_TRANSACTION:
                assert reply != null;
                reply.writeString(DESCRIPTOR);
                return true;
            case TRANSACTION_getPid:
                data.enforceInterface(DESCRIPTOR);
                int result = this.getPid();
                assert reply != null;
                reply.readException();
                reply.writeInt(result);
                return true;


        }
        return super.onTransact(code, data, reply, flags);
    }
}
