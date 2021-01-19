package com.github.binder_client;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * @author : dev
 * @version :
 * @Date :  12/20/20 10:44 PM
 * @Desc :
 */
public class MyServiceProxy implements IMyService {

    private IBinder mRemote;

    public MyServiceProxy(IBinder remote) {
        mRemote = remote;
    }

    @Override
    public void sayHello(String str) throws RemoteException {
        android.os.Parcel _data = Parcel.obtain();
        android.os.Parcel _reply = Parcel.obtain();
        try {
            // define it in super class.
            _data.writeInterfaceToken(DESCRIPTOR);
            _data.writeString(str);
            mRemote.transact(TRANSACTION_say,_data,_reply,0);
            _reply.readException();
        } finally {
            _reply.recycle();
            _data.recycle();
        }

    }

    @Override
    public IBinder asBinder() {


        return mRemote;
    }
}
