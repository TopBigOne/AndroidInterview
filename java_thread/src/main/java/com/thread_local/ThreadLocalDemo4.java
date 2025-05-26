package com.thread_local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : dev
 * @version :
 * @Date :  2022/10/5 06:40
 * @Desc :
 * https://www.youtube.com/watch?v=ad2li3MEv9o
 * https://www.youtube.com/watch?v=dymtsbH9fg8
 * 在池化资源中，使用ThreadLocal 以后，一定要 调用remove();
 */
public class ThreadLocalDemo4 {
    static class MyData {
        ThreadLocal<Integer> threadLocalField = ThreadLocal.withInitial(() -> 0);


        public void add() {
            threadLocalField.set(threadLocalField.get() + 1);
        }
    }

    public static void main(String[] args) {
        MyData myData = new MyData();

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            for (int i = 1; i <= 5; i++) {
                threadPool.submit(() -> {
                    try {
                        int beforeInt = myData.threadLocalField.get();
                        myData.add();
                        int afterInt = myData.threadLocalField.get();
                        System.err.println(Thread.currentThread().getName() + " beforeInt : " + beforeInt);
                        System.err.println(Thread.currentThread().getName() + " afterInt  : " + afterInt);
                        System.err.println("|-------------------- ----------------------------|");
                    } finally {
                        myData.threadLocalField.remove();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
