package com.android.java_thread.a1b2c3;

import java.util.concurrent.locks.LockSupport;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-12 00:50
 * @Desc : LockSupport park 当前线程阻塞（停止）
 * 交替打印字符
 */
public class T02_00_LockSupport {

    private Thread t1;
    private Thread t2;
    private char[] aI = "1234567".toCharArray();
    private char[] aC = "ABCDEFG".toCharArray();

    public static void main(String[] args) {
        T02_00_LockSupport lockSupport = new T02_00_LockSupport();
        // lockSupport.test1();
        // lockSupport.test2();
        lockSupport.test3();
    }

    private void test1() {

        // Thread t1 = null, t2 = null;
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        t1 = new Thread(() -> {
            for (char c : aI) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : aC) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();
    }



    public void test2() {
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        t1 = new Thread(() -> {
            for (char c : aI) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }

        }, "t1");

        t2 = new Thread(() -> {
            for (char c : aC) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
    }

    public void test3() {
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : aI) {
                    // 上来就打印一个字符
                    System.out.print(c);
                    // 立马解锁t2
                    LockSupport.unpark(t2);
                    // 自己锁住自己
                    LockSupport.park();
                }
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : aC) {
                    // 上来就锁住自己，防止自己先打印
                    LockSupport.park();
                    // 被t1解锁了，开始打印一个字符
                    System.out.print(c);
                    // 解锁t1 线程，让t1 能继续打印
                    LockSupport.unpark(t1);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
