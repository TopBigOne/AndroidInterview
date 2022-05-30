package com.android.interview.activity;


import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initEvent();

        init();

    }

    private void init() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {

            @Override
            public void onFragmentResumed(@NonNull FragmentManager fm, @NonNull Fragment f) {
                super.onFragmentResumed(fm, f);
                onSingleFragmentResumed(fm, f);
            }

        }, false);
    }


    protected void onSingleFragmentResumed(FragmentManager fm, Fragment f) {

    }

    protected abstract void initView();

    protected abstract void initEvent();

    protected abstract int getLayoutId();

    public void print(Object str) {
        if (str == null) {
            return;
        }
        RadioGroup radioGroup;

/*

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case  "智能模式的rb is":
                        selectSamrtMode();
                        break;
                        case  "快速浏览模式的rb is":
                        selectBrowerMode();
                        break;
                    case "video模式的rb is":
                        selectVideotMode();
                        break;

                }

            }
        });

*/

    }
}