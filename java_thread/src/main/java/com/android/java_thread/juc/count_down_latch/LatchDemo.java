package com.android.java_thread.juc.count_down_latch;

import java.util.concurrent.CountDownLatch;

/**
 * @author : dev
 * @version :
 * @Date :  11/27/20 11:19 PM
 * @Desc : https://www.cnblogs.com/linkworld/p/7819270.html （学习一下 countDownLatch）
 */
public class LatchDemo implements Runnable {
    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this){
            try {
                for (int i = 0; i < 5000; i++) {
                    if (i%2==0) {
                        System.out.println(i);
                    }
                }
            } finally {
                // 线程数量递减
                latch.countDown();
            }
        }
    }
}
