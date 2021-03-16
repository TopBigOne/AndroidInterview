package com.jar.yu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.jar.yu.R;

/**
 * @author : Jakarta
 * @version :
 * @Date : 10/9/20 10:37 PM
 * @Desc :
 */
public class QuestionDialog extends Dialog {

    private TextView mTvTitle;
    private Button   mBtnYes;
    private Button   mBtnNo;


    private Handler mUiHandler = new Handler(Looper.getMainLooper());

    public QuestionDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_question);

        mTvTitle = findViewById(R.id.tv_title);
        mBtnYes = findViewById(R.id.btn_yes);
        mBtnNo = findViewById(R.id.btn_no);

        mBtnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // testFunOne();
                testFunTwo();


            }
        });

    }

    /**
     * Only the original thread that created a view hierarchy can touch its views.
     */
    private void testFunTwo() {
        mUiHandler.post(new Runnable() {
            @Override
            public void run() {
                String s = mTvTitle.getText().toString();
                mTvTitle.setText(s + "？");
            }
        });


    }

    private void testFunOne() {
        String s = mTvTitle.getText().toString();
        mTvTitle.setText(s + "？");

        boolean uiThread = Looper.myLooper() == Looper.getMainLooper();
        Toast.makeText(getContext(), "Ui thread = " + uiThread, Toast.LENGTH_LONG).show();
    }

    public void show(String title) {
        mTvTitle.setText(title);
        show();
    }



}
