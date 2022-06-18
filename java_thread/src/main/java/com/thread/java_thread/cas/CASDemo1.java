package com.thread.java_thread.cas;


import java.util.concurrent.CountDownLatch;

/**
 * @author : Jakarta
 * @version :
 * @Date : 9/10/20 10:19 PM
 * @Desc : 学习 CAS 原理。
 */
public class CASDemo1 {

    static volatile int count = 0;


    /**
     * 这个函数加锁 ：synchronized，比较耗时
     */
    public  static void request() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int expertCount;
        while (!compareAndSwap((expertCount = getCount()), expertCount + 1)) {
            // empty
        }
    }

    public static synchronized boolean compareAndSwap(int expectCount, int newCount) {
        if (getCount() == expectCount) {
            count = newCount;
            return true;
        }
        return false;
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int threadSize = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            Thread thread = new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        request();
                    }
                } finally {
                    countDownLatch.countDown();
                }
            });

            thread.start();
        }

        try {
            countDownLatch.await();
            long endTime = System.currentTimeMillis();
            System.out.println("当前线程：" + Thread.currentThread().getName() + ", " +
                    "耗时：" + (endTime - startTime) + " count : " + count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
