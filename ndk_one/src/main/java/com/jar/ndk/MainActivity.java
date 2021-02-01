package com.jar.ndk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String result = getTxt();
        TextView mainTv = (TextView) findViewById(R.id.tv_main);
        mainTv.setText(result);


    }

    public native String getTxt();
}
