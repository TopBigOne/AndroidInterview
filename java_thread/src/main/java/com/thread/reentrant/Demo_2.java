package com.thread.reentrant;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : dev
 * @version :
 * @Date :  7/18/21 6:46 PM
 * @Desc : 用 reentrantLock 实现一个生产者和消费者
 * <p>
 * 阳哥语录，多线程编程：
 * 1：线程操作资源类
 * 2：判断  ---干活-----通知
 * 3：防止虚假唤醒（判断写在 while 里）
 */
public class Demo_2 {
    static class ShareData {
        private int number = 0;
        private final ReentrantLock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        /**
         * 增加
         */
        public void increment() {
            try {
                lock.lock();
                // 1: 判断
                while (number != 0) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 2: 干活
                number++;
                System.out.println(Thread.currentThread().getName() + " : " + number);
                // 3:通知，唤醒
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        /**
         * 减少
         */
        public void decrement() {
            try {
                lock.lock();
                // 等于 0 了，需要等待
                while (number == 0) {
                    condition.await();
                }
                number--;
                System.out.println(Thread.currentThread().getName() + " : " + number);
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread("AA") {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 5; i++) {
                    shareData.increment();
                }
            }
        }.start();

        //---------------------------------------------
        new Thread("BB") {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 5; i++) {
                    shareData.decrement();
                }
            }
        }.start();
    }

}
