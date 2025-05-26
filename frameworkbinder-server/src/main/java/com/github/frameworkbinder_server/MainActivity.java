package com.github.frameworkbinder_server;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.github.frameworkbinder_server.diy.IRemote;
import com.github.frameworkbinder_server.diy.Stub;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity : ";

    Button btnGetPid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetPid = findViewById(R.id.btn_get_pid);
        initEvent();

    }

    private void initEvent() {
        btnGetPid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, RemoteService.class);
                // 绑定服务
                bindService(intent, connection, Service.BIND_AUTO_CREATE);
            }
        });
    }


    final private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: name :" + name.getClassName());
            IRemote remoteService = Stub.asInterface(service);
            try {
                int pid = remoteService.getPid();
                Log.d(TAG, "onServiceConnected: get the pid is :" + pid);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: name :" + name.getClassName());

        }
    };
}
