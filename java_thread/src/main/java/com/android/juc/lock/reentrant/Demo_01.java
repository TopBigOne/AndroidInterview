package com.android.juc.lock.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/6 17:48
 * @Desc :
 */
public class Demo_01 {
    public static void main(String[] args) {
        Demo_01 demo_01 = new Demo_01();
        demo_01.test();

    }


    public void test() {
        ReentrantLock lock = new ReentrantLock(true);
        try {
            lock.lock();
            System.out.println("当前线程获取的锁-1 :" + lock.getHoldCount());
            try {
                if (lock.tryLock(5, TimeUnit.SECONDS)) {
                    // do sth...
                    System.out.println("当前线程获取的锁-2 :" + lock.getHoldCount());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("当前释放锁-3: " + lock.getHoldCount());
                lock.unlock();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("当前释放锁-4: " + lock.getHoldCount());

            lock.unlock();

        }


    }
}
