package com.thread.reentrant;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/8/4 11:09
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class TestLeeLock {
    static int count = 0;
    static LeeLock lock = new LeeLock();
    public static void main(String[] args) {
        testOne();

    }

    private static void testOne() {
        Thread thread1 = new Thread(runnable,"jar1");
        Thread thread2 = new Thread(runnable,"jar2");

        try {
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            System.out.println("count: "+count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Runnable runnable = () -> {
        lock.lock();
        for (int i = 0; i < 10000; i++) {
            count++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.release();

    };
}
