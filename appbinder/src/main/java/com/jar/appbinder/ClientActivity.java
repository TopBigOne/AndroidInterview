package com.jar.appbinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ClientActivity extends AppCompatActivity {

    private static final String TAG = "ClientActivity : ";
    private IRemoteService mRemoteService;
    boolean mIsBound;
    TextView mCallBackTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //copy
        mCallBackTv = (TextView) findViewById(R.id.tv_callback);
        mCallBackTv.setText(R.string.remote_service_unattached);

    }




    public void clickHandler(View view){
        switch (view.getId()){
            case R.id.btn_bind:
                bindRemoteService();
                break;

            case R.id.btn_unbind:
                unbindRemoteService();
                break;

            case R.id.btn_kill:
                killRemoteService();
                break;
        }
    }

    private void bindRemoteService() {
        Log.i(TAG, "bindRemoteService: ");
        Intent intent  = new Intent(ClientActivity.this,RemoteService.class);
        intent.setAction(IRemoteService.class.getName());
        bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);
        mIsBound = true;


    }

    private void unbindRemoteService() {
        if (!mIsBound) {
            return;
        }
        Log.i(TAG, "unbindRemoteService: ");
        unbindService(mServiceConnection);

    }

    /**
     * 杀死远程服务
     */
    private void killRemoteService() {
        Log.i(TAG, "killRemoteService: ");
        try {
            android.os.Process.killProcess(mRemoteService.getPid());
            mCallBackTv.setText(R.string.kill_success);
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(ClientActivity.this, R.string.kill_failure, Toast.LENGTH_SHORT).show();
        }

    }

    /*
     *
     * 用于监控远程服务连接的状态
     * Interface for monitoring the state of an application service.  See
     * {@link android.app.Service} and
     * {@link Context#bindService Context.bindService()} for more information.
     * <p>Like many callbacks from the system, the methods on this class are called
     * from the main thread of your process.
     */
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mRemoteService = IRemoteService.Stub.asInterface(service);
            String pidInfo = null;
            try {
                MyData myData = mRemoteService.getMyData();
                pidInfo = "pid = "+mRemoteService.getPid()+
                        ", data1 = "+mRemoteService.getMyData().getData1()+
                        ", data2 = "+mRemoteService.getMyData().getData2();


            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.i(TAG, "onServiceConnected: onServiceConnected "+pidInfo);
            mCallBackTv.setText(pidInfo);
            Toast.makeText(ClientActivity.this, R.string.remote_service_connected, Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected: ");
            mCallBackTv.setText(R.string.remote_service_disconnected);
            mRemoteService = null;
            Toast.makeText(ClientActivity.this, R.string.remote_service_disconnected, Toast.LENGTH_SHORT).show();


        }
    };


}
