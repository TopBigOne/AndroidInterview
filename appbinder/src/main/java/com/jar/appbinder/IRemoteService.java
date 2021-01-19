/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.jar.appbinder;
// Declare any non-default types here with import statements

public interface IRemoteService extends android.os.IInterface {
    /**
     * Default implementation for IRemoteService.
     */
    class Default implements IRemoteService {
        @Override
        public int getPid() throws android.os.RemoteException {
            return 0;
        }

        @Override
        public MyData getMyData() throws android.os.RemoteException {
            return null;
        }

        @Override
        public android.os.IBinder asBinder() {
            return null;
        }
    }




    /**
     * Local-side IPC implementation stub class.
     */
    abstract class Stub extends android.os.Binder implements IRemoteService {
        private static final String DESCRIPTOR = "com.jar.appbinder.IRemoteService";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an com.jar.appbinder.IRemoteService interface,
         * generating a proxy if needed.
         */
        public static IRemoteService asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof IRemoteService))) {
                return ((IRemoteService) iin);
            }
            return new Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            String descriptor = DESCRIPTOR;
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(descriptor);
                    return true;
                }
                case TRANSACTION_getPid: {
                    data.enforceInterface(descriptor);
                    int _result = this.getPid();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_getMyData: {
                    data.enforceInterface(descriptor);
                    MyData _result = this.getMyData();
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        private static class Proxy implements IRemoteService {

            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public int getPid() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getPid, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().getPid();
                    }
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public MyData getMyData() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                MyData _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getMyData, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().getMyData();
                    }
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = MyData.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            public static IRemoteService sDefaultImpl;
        }

        static final int TRANSACTION_getPid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_getMyData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);

        public static boolean setDefaultImpl(IRemoteService impl) {
            // Only one user of this interface can use this function
            // at a time. This is a heuristic to detect if two different
            // users in the same process use this function.
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static IRemoteService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }

    public int getPid() throws android.os.RemoteException;

    public MyData getMyData() throws android.os.RemoteException;
}
