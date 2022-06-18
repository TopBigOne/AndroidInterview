package com.thread.work_and_consume;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/3 02:00
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :  https://www.bilibili.com/video/BV1ph411171i?p=41
 */
public class Demo1 {

    static class ShareData {
        int number = 0;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void increment() {
            lock.lock();

            try {
                // 1: 判断
                while (number != 0) {
                    condition.await();
                }
                // 2: 干活
                number++;
                System.out.println(Thread.currentThread().getName() + "\t " + number);
                condition.signalAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void decrement() {
            lock.lock();

            try {
                while (number != 1) {
                    condition.await();
                }

                number--;
                System.out.println(Thread.currentThread().getName() + "\t " + number);
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        }


    }

    /**
     * 1: 线程   操作   资源类
     * 2: 判断    干活    通知
     * 3: 防止虚假唤醒机制（while）
     *
     * @param args
     */
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    shareData.increment();
                }

            }
        }, "生产 ： ").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    shareData.decrement();
                }
            }
        }, "消费 ： ").start();

    }


}
