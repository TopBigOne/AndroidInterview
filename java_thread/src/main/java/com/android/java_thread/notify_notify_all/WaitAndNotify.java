package com.android.java_thread.notify_notify_all;

import java.util.Objects;

/**
 * @author : dev
 * @version :
 * @Date :  4/18/21 1:30 PM
 * @Desc : 线程间的协作
 */
public class WaitAndNotify {
    public static void main(String[] args) {
        Object co = new Object();
        System.out.println(co);

        for (int i = 0; i < 5; i++) {
            MyThread t = new MyThread("Thread " + i, co);
            t.start();
        }

        try {
            Thread.sleep(2000);

            // 为什么这行代码要用锁了，不加锁的话，会怎么样的？
            // 当然会报错啦....java.lang.IllegalMonitorStateException异常
            //1：当前线程不含有当前对象的锁资源的时候，调用obj.wait()方法;
            //2：当前线程不含有当前对象的锁资源的时候，调用obj.notify()方法。
            //3：当前线程不含有当前对象的锁资源的时候，调用obj.notifyAll()方法。
            // 加了synhronized ,就是为了让当前线程获取锁资源；
            synchronized (co) {

                // 使用 notifyAll，所有的线程都会被唤醒，去重新竞争锁；
                //   co.notifyAll();

                // 使用notifyAll ，目前看 log，只会让 Thread-0 唤醒；
                co.notify();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static class MyThread extends Thread {
        private String name;
        private Object co;

        public MyThread(String name, Object co) {
            this.name = name;
            this.co = co;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " is waitting");
                synchronized (co) {
                    co.wait();
                    System.out.println(name + " has been notified.");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
