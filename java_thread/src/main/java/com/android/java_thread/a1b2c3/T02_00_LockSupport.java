package com.android.java_thread.a1b2c3;

import java.util.concurrent.locks.LockSupport;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-12 00:50
 * @Desc : LockSupport park 当前线程阻塞（停止）
 */
public class T02_00_LockSupport {
    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

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


}
