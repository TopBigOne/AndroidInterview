package com.android.count_down_latch;

import java.util.concurrent.CountDownLatch;

/**
 * @author : dev
 * @version :
 * @Date :  11/27/20 11:23 PM
 * @Desc :
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(10);
        LatchDemo ld = new LatchDemo(latch);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(ld).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时时间：" + (endTime - startTime));
    }
}
