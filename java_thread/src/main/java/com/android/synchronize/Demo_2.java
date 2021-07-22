package com.android.synchronize;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/12 20:16
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Demo_2 {
    final Object lock = new Object();

    public static void main(String[] args) {
        Demo_2 demo_2 = new Demo_2();
        demo_2.testOne();
    }

    public void testOne() {
        System.out.println(" testOne  start -- 当前线程："+Thread.currentThread().getName());
        synchronized (lock) {
            System.out.println(" testOne 获取到锁");
            try {
                System.out.println(" testOne 开始睡眠");
                Thread.sleep(3000);
                System.out.println(" testOne 醒了");
                testTwo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void testTwo() {
        System.out.println(" testTwo start -- 当前线程："+Thread.currentThread().getName());
        synchronized (lock) {
            System.out.println(" testTwo 获取到锁");
        }
    }
}
