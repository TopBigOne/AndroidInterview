package com.android.java_thread.notify_notify_all;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * @author : dev
 * @version :
 * @Date :  4/18/21 12:28 AM
 * @Desc : 百度的面试题，B 线程怎么等待 A 线程完成工作
 */
public class A_Wait_B {
    static TA mTA;
    static TB mTB;

    public static void main(String[] args) {
        mTA = new TA();
        mTB = new TB();
        mTA.start();
        mTB.start();
        mTA.notify();
    }

    static class TA extends Thread {
        @Override
        public void run() {
            System.out.println("TA 开始噼里啪啦的做一些耗时操作...");

            try {
                Thread.sleep(5);
                System.out.println("TA 的工作做完了.....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(mTB);

        }
    }

    static class TB extends Thread {
        @Override
        public void run() {

            System.out.println("TB 开始锁定，等待TA 操作完");
            LockSupport.park();
            System.out.println("TB 开始噼里啪啦的做一些耗时操作...");
        }
    }


}
