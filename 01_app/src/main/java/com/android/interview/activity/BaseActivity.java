package com.android.interview.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        String s= "232";
        s.contains();
        s.indexOf(s)

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.substring();

        stringBuilder.indexOf()
        stringBuilder.

        initView();
        initEvent();
    }

    protected abstract void initView();

    protected abstract void initEvent();

    protected abstract int getLayoutId();

    public void print(Object str) {
        if (str == null) {
            return;
        }

        System.out.println(str);
    }
}