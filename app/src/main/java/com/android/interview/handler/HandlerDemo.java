package com.android.interview.handler;

import android.app.ActivityManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-07 13:15
 * @Desc :
 */
public class HandlerDemo {
    public void test() {
        HandlerThread handlerThread = new HandlerThread();
        handlerThread.start();
    }

    class HandlerThread extends Thread {
        Handler handler;

        @Override

        public void run() {
            Looper.prepare();
            Message message = Message.obtain();
            message.what = 345;


            handler = new Handler() {
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    int what = msg.what;
                    System.out.println("what:" + what);


                }
            };


            Looper.loop();


        }
    }
}
