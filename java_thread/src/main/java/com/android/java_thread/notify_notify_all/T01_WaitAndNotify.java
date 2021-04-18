package com.android.java_thread.notify_notify_all;

import java.util.Collections;

/**
 * @author : dev
 * @version :
 * @Date :  4/18/21 7:25 PM
 * @Desc :
 */
public class T01_WaitAndNotify {
    private static Object o = new Object();

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println("start...");

                synchronized (o) {
                    try {
                        Thread.sleep(1);
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("end....");
            }
        }.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (o) {
            System.out.println("使用 notify ，子线程继续工作:");
            o.notify();
            //o.notifyAll();
        }
    }
}
