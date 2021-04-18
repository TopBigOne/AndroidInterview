package com.android.java_thread.notify_notify_all;

import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  4/18/21 6:13 PM
 * @Desc : 生产者
 *
 * https://juejin.cn/post/6844903801363628045
 */
public class Producer implements Runnable {
    private List<Integer> cache;

    public Producer(List<Integer> cache) {
        this.cache = cache;
    }

    @Override
    public void run() {
        while (true) {
            put();
        }
    }

    public void put() {
        synchronized (cache) {
            try {
                while (cache.size() == 1) {
                    cache.wait();
                }
                Thread.sleep(1000);
                cache.add(1);
                System.out.println(Thread.currentThread().getName() + " 生产者生产了一条");
                cache.notify();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
