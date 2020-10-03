package com.jar.yu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

/*
 *  1:在 子线程中调用
 * */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity:";

    private Handler mHandler = new Handler();

    DialogThred               mDialogThred;
    UpdateTextThreadTwoThread mDialogThredTwo;
    Button                    buttonTwo;
    Button                    buttonThree;
    Button                    buttonFive;
    private Button                       buttonOne;
    private DirectCreatHandlerThread     mDirectCreatHandlerThread;
    private CreatHandlerWithLooperThread mCreatHandlerWithLooperThread;
    ReceiveMsgFromMainThread mReceiveMsgFromMainThread;
    private Button buttonFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate:----- ");
        initThread();

        buttonOne = (Button) findViewById(R.id.btn_one);
        buttonTwo = (Button) findViewById(R.id.btn_two);
        buttonThree = (Button) findViewById(R.id.btn_three);
        buttonFour = (Button) findViewById(R.id.btn_four);
        buttonFive = (Button) findViewById(R.id.btn_five);
        mDialogThredTwo.start();
        mReceiveMsgFromMainThread.start();
        initEvent();
    }

    private void initThread() {
        mDialogThred = new DialogThred(this);
        mDirectCreatHandlerThread = new DirectCreatHandlerThread();
        mDialogThredTwo = new UpdateTextThreadTwoThread(this);
        mCreatHandlerWithLooperThread = new CreatHandlerWithLooperThread();
        mReceiveMsgFromMainThread = new ReceiveMsgFromMainThread(this);
    }

    private void initEvent() {
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialogThred.start();
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialogThredTwo.start();
            }
        });

        // 在子线程直接创建
        // 会 crash哦......Can't create handler inside thread that has not called Looper.prepare()
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDirectCreatHandlerThread.start();
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDirectCreatHandlerThread.start();
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCreatHandlerWithLooperThread.start();
            }
        });

        // 主线程向子线程发消息
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mReceiveMsgFromMainThread.mHandler == null) {
                    Log.e(TAG, "onClick: mReceiveMsgFromMainThread`s handle is null.... ");
                    return;
                }
                Message message = Message.obtain();
                message.what = 0x123;
                message.obj = "瑞幸咖啡....在新东方旁边";
                mReceiveMsgFromMainThread.mHandler.sendMessage(message);
            }
        });

    }


    static class DialogThred extends Thread {
        private Context mContext;

        public DialogThred(MainActivity mainActivity) {
            mContext = mainActivity;
        }

        @Override
        public void run() {
            Looper.prepare();
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            String threadName = "当前线程的名字 :" + Thread.currentThread().getName();
            builder.setTitle("子线程更新 Dialog").setMessage(threadName);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            Looper.loop();
        }
    }

    /**
     * ViewRootImp 在 onCreate() 时还没创建；
     * 在 onResume()时，即ActivityThread 的 handleResumeActivity() 执行后才创建；
     * 调用 requestLayout()，走到 checkThread() 时就报错了。
     */
    static class UpdateTextThreadTwoThread extends Thread {
        private MainActivity mContext;

        public UpdateTextThreadTwoThread(MainActivity mainActivity) {
            mContext = mainActivity;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(1);
                Log.e(TAG, "run: update ui");
                mContext.buttonTwo.setText("hhhhh---Thread Name :" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    static class DirectCreatHandlerThread extends Thread {
        @Override
        public void run() {
            Handler handler = new Handler();
        }
    }

    static class CreatHandlerWithLooperThread extends Thread {
        @Override
        public void run() {
            Looper.prepare();
            Handler handler = new Handler();
        }
    }

    static class ReceiveMsgFromMainThread extends Thread {

        private Context mContext;

        public Handler mHandler;

        public ReceiveMsgFromMainThread(Context context) {
            mContext = context;
        }

        @Override
        public void run() {
            Looper.prepare();
            mHandler = new Handler() {
                @Override
                public void handleMessage(@NonNull Message msg) {
                    if (msg.what == 0x123) {
                        String mainMsg = (String) msg.obj;
                        Context context;
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

                        builder.setTitle(" 子线程 dialog").setMessage("收到主线程消息：" + mainMsg);
                        builder.create().show();
                    }
                }
            };
            Looper.loop();

        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume()---");
    }


}
