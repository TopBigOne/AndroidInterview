package com.android.java_thread.a1b2c3;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-14 15:00
 * @Desc :  自旋锁实现
 */
public class T06_00_cas {
    enum ReadyToRun {T1, T2}

    // 思考，为什么要用 volatile
    static volatile ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (char c : aI) {
                // 现在r不是 t1，自旋，阻塞住.....
                while (r != ReadyToRun.T1) {
                }

                System.out.print(c);
                r = ReadyToRun.T2;
            }

        }, "t1").start();


        new Thread(() -> {
            for (char c : aC) {
                // 自旋
                while (r != ReadyToRun.T2) {
                }
                System.out.print(c);
                r = ReadyToRun.T1;
            }


        }, "t2").start();


    }
}
