package com.android.inorder_task;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/7 18:16
 * @Url :
 * @Level :  easy
 * @Desc :  有三个线程T1，T2，T3，怎么确保它们按顺序执行？
 * @Counter :
 * @Answer :
 */
public class InOrderTask {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition2 = lock.newCondition();
    static Condition condition3 = lock.newCondition();

    static volatile int count = 0;

    public static void main(String[] args) {
        InOrderTask inOrderTask = new InOrderTask();
        inOrderTask.start();
    }

    private void start() {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
        Thread t3 = new Thread(new T3());
        t1.start();
        t2.start();
        t3.start();
    }

    static class T1 implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("------------> T1 执行");
                count++;
                condition2.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    static class T2 implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                while (count != 1) {
                    condition2.await();
                }
                System.out.println("------------> T2 执行");
                count++;
                condition3.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class T3 implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                while (count != 2) {
                    condition3.await();
                }
                System.out.println("------------> T3 执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
