package com.hencoder.plus.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hencoder.plus.R;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnAvatarView;
    private Button mBtnAvatarDashBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAvatarView = findViewById(R.id.btn_avatar_view);
        mBtnAvatarDashBoard = findViewById(R.id.btn_avatar_dash_board);

        mBtnAvatarView.setOnClickListener(this);
        mBtnAvatarDashBoard.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int resId = v.getId();
        switch (resId) {
            case R.id.btn_avatar_view:
                startActivity(new Intent(MainActivity.this, AvatarViewActivity.class));
                break;
            case R.id.btn_avatar_dash_board:
                startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                break;
            default:


        }


    }


}
