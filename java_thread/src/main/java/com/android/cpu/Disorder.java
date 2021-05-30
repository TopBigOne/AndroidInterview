package com.android.cpu;

import java.util.concurrent.CountDownLatch;

/**
 * @author : dev
 * @version :
 * @Date :  5/30/21 8:19 PM
 * @Desc : cpu 的乱序执行
 */
public class Disorder {
    public static int x = 0, y = 0;
    public static int a = 0, b = 0;

    public static void main(String[] args) {
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            CountDownLatch latch = new CountDownLatch(2);
            Thread one = new Thread(() -> {
                a = 1;
                x = b;
                latch.countDown();
            });
            Thread two = new Thread(() -> {
                b = 1;
                y = a;
                latch.countDown();
            });

            one.start();
            two.start();

        }
    }
}
