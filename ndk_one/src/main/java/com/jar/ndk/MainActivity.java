package com.jar.ndk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }
   private TextView mainTv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        mainTv = (TextView) findViewById(R.id.tv_main);
    }

    private void initEvent() {
        mainTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = getTxt();
                mainTv.setText(result);
            }
        });

    }

    public native String getTxt();

    public native  String stringFromJNI();
    public native void startTicks();
    public native void StopTicks();

}
