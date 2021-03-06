package com.jar.plt_hook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * https://juejin.cn/post/6868916019746996237
 * https://github.com/AndroidAdvanceWithGeektime
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThreadHook.enableThreadHook();
                Toast.makeText(MainActivity.this, "开启成功", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.newthread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("HOOOOOOOOK", "thread name:" + Thread.currentThread().getName());
                        Log.e("HOOOOOOOOK", "thread id  :" + Thread.currentThread().getId());
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("HOOOOOOOOK", "inner thread name:" + Thread.currentThread().getName());
                                Log.e("HOOOOOOOOK", "inner thread id  :" + Thread.currentThread().getId());

                            }
                        }).start();
                    }
                }).start();
            }

        });
    }
}