package com.android.interview.event;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.interview.R;
import com.android.interview.activity.BaseActivity;

import java.util.HashMap;

public class OnTouchActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener {
    private static final String TAG = "OnTouchActivity: ";

    private Button btnOne;
    private TextView tvResult;

    private StringBuffer sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        btnOne = findViewById(R.id.btn_one);
        btnOne.setMovementMethod(ScrollingMovementMethod.getInstance());
        tvResult = findViewById(R.id.tv_result_one);
        sb = new StringBuffer();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //  return super.onTouchEvent(event);
        String actionValue = getActionName(event.getAction());
        Log.d(TAG, "Activity 的 onTouchEvent : " + actionValue);
        return false;
    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_one:
                String actionValue = getActionName(event.getAction());
                Log.d(TAG, " btn_one 触发了 onTouch 事件---" + actionValue);
                sb.append("btn_one 触发了 view 的onTouch事件 : ").append(actionValue).append("\n");
                print(sb);
                setResultOne();
                return true;
        }
        return false;
    }

    /**
     * 返回 Action 类型
     *
     * @param action
     * @return
     */
    private String getActionName(int action) {
        String actionValue = "";
        if (action == MotionEvent.ACTION_DOWN) {
            actionValue = "ACTION_DOWN";
        }
        if (action == MotionEvent.ACTION_UP) {
            actionValue = "ACTION_UP";
        }
        if (action == MotionEvent.ACTION_MOVE) {
            actionValue = "ACTION_MOVE";
        }
        return actionValue;
    }

    @Override
    protected void initEvent() {
        btnOne.setOnClickListener(this);
        btnOne.setOnTouchListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_on_touch;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_one:
                sb.append("btn_one  触发了 click 事件");
                Log.d(TAG, "onClick: 触发了 click 事件");
                print(sb);
                setResultOne();
                break;
        }
    }

    public void setResultOne() {
        sb.append("|--------------------|").append("\n");
        tvResult.setText(sb.toString());
    }



}