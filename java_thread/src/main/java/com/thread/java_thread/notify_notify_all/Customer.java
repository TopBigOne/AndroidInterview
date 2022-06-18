package com.thread.java_thread.notify_notify_all;

import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  4/18/21 8:30 PM
 * @Desc :
 */
public class Customer implements Runnable {
    private List<Integer> cache;

    public Customer(List<Integer> cache) {
        this.cache = cache;
    }

    private void custom() {
        synchronized (cache) {
            try {
                while (cache.size() == 0) {
                    cache.wait();
                }
                cache.remove(0);
                System.out.println(Thread.currentThread().getName() + " 消费者了消费一条");
                cache.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void run() {
        while (true) {
            custom();
        }
    }


}
