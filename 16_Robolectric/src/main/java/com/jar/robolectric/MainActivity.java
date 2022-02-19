package com.jar.robolectric;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * https://blog.csdn.net/lyabc123456/article/details/89481000
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}