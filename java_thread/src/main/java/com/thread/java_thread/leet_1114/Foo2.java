package com.thread.java_thread.leet_1114;

import java.util.concurrent.CountDownLatch;

/**
 * @author : dev
 * @version :
 * @Date :  2/2/21 10:38 PM
 * @Desc :
 */
public class Foo2 {
    private CountDownLatch second = new CountDownLatch(1);
    private CountDownLatch third = new CountDownLatch(1);
    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.await();
        printSecond.run();
        third.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.await();
        printThird.run();
    }
}
