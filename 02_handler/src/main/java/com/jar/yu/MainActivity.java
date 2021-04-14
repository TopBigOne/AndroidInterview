package com.jar.yu;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.*;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.jar.yu.dialog.QuestionDialog;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/*
 *  1:在 子线程中调用
 *
 * */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity:";
    public static final int MESSAGE_TYPE_SYNC = 1;
    public static final int MESSAGE_TYPE_ASYN = 2;
    private UpdateTextThreadTwoThread mDialogThredTwo;

    private Handler mHandler = new Handler();
    private Handler mWorkThreadHandler;

    private DialogThred mDialogThred;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFive;
    private Button buttonSix;

    private Button buttonOne;
    private DirectCreateHandlerThread mDirectCreateHandlerThread;
    private CreateHandlerWithLooperThread mCreateHandlerWithLooperThread;
    ReceiveMsgFromMainThread mReceiveMsgFromMainThread;
    private Button buttonFour;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonTen;

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

        buttonSix = (Button) findViewById(R.id.btn_six);
        buttonSeven = (Button) findViewById(R.id.btn_seven);
        buttonEight = (Button) findViewById(R.id.btn_eight);
        buttonNine = (Button) findViewById(R.id.btn_nine);
        buttonTen = (Button) findViewById(R.id.btn_ten);
        mDialogThredTwo.start();
        mReceiveMsgFromMainThread.start();
        SubThread subThread = new SubThread();
        subThread.run2();

        //new Handler().post();
        System.out.println("jar--B");
        initEvent();
        initWorkThreadHandler();

    }

    class SubThread implements Runnable{
        @Override
        public void run() {
            System.out.println("jar--A:current thread:"+Thread.currentThread().getName());
        }

        public void run2() {
            System.out.println("run2#jar--A:current thread:"+Thread.currentThread().getName());
        }
    }


    /**
     * 初始化工作线程
     */
    private void initWorkThreadHandler() {
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                mWorkThreadHandler = new Handler() {
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        if (msg.what == MESSAGE_TYPE_SYNC) {
                            Log.d(TAG, "收到普通消息");
                        } else if (msg.what == MESSAGE_TYPE_ASYN) {
                            Log.d(TAG, "收到异步消息");
                        }
                    }
                };
                Looper.loop();

            }
        }.start();

    }

    private void initThread() {
        mDialogThred = new DialogThred(this);
        mDirectCreateHandlerThread = new DirectCreateHandlerThread();
        mDialogThredTwo = new UpdateTextThreadTwoThread(this);
        mCreateHandlerWithLooperThread = new CreateHandlerWithLooperThread();
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
                mDirectCreateHandlerThread.start();
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDirectCreateHandlerThread.start();
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCreateHandlerWithLooperThread.start();
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

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestAQuestion();
            }
        });

        // 发送同步屏障
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                sendSyncBarrier();
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    removeSyncBarrier();
                }
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSyncMessage();
            }
        });
        buttonTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                    sendAsyncMessage();
                }
            }
        });


    }

    private int token = -1;

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void sendSyncBarrier() {
        Log.d(TAG, "  sendSyncBarrier --插入同步屏障...  ");
        MessageQueue queue = mWorkThreadHandler.getLooper().getQueue();
        try {
            Method method = MessageQueue.class.getDeclaredMethod("postSyncBarrier");
            method.setAccessible(true);
            token = (int) method.invoke(queue);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            Log.d(TAG, "sendSyncBarrier:  " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 移除屏障
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void removeSyncBarrier() {
        Log.d(TAG, "remoceSyncBarrier: 移除同步屏障.... ");
        MessageQueue queue = mWorkThreadHandler.getLooper().getQueue();
        try {
            Method method = MessageQueue.class.getDeclaredMethod("removeSyncBarrier", int.class);
            method.setAccessible(true);
            method.invoke(queue, token);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            Log.d(TAG, "remoceSyncBarrier:  " + e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * 发送同步消息
     */
    public void sendSyncMessage() {
        Log.d(TAG, "sendSyncMessage: 插入普通消息 ");
        Message message = Message.obtain();
        message.what = MESSAGE_TYPE_SYNC;
        mWorkThreadHandler.sendMessageDelayed(message, 1000);
    }

    /**
     * 往消息队列插入异步消息
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public void sendAsyncMessage() {
        Log.d(TAG, "sendAsyncMessage: 插入异步消息 ");
        Message message = Message.obtain();
        message.setAsynchronous(true);
        message.what = MESSAGE_TYPE_ASYN;
        mWorkThreadHandler.sendMessageDelayed(message, 1000);
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

    static class DirectCreateHandlerThread extends Thread {
        @Override
        public void run() {
            Handler handler = new Handler();
        }
    }

    static class CreateHandlerWithLooperThread extends Thread {
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

    private void requestAQuestion() {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 模拟服务器请求，返回问题
                String title = "Long time no see！";
                showQuestionInDialog(title);
            }
        }.start();
    }

    private void showQuestionInDialog(String title) {
        Looper.prepare(); // 增加部分

        QuestionDialog questionDialog = new QuestionDialog(this);
        questionDialog.show(title);
        Looper.loop(); // 增加部分
    }


    public Bitmap sourceBitmap(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        Matrix matrix = new Matrix();
        matrix.postRotate(-90);

        Bitmap tempBitmap = Bitmap.createBitmap(bitmap,0,0,3,2,matrix,false);
        return tempBitmap;

    }

    /**
     * 座位状态
     */
    enum SeatStatus{
        /*可选*/
        ENABLE,
        /*锁定*/
        LOCK,
        /*占用*/
        EXCLUSIVE
    }

}
