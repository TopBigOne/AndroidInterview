package com.android.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/3 00:10
 * @Url :
 * @Level :  easy
 * @Desc :  创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
 * @Counter :
 * @Answer :
 */
public class NewFixedThreadPoolDemo {
    public static void main(String[] args) {
        NewFixedThreadPoolDemo demo = new NewFixedThreadPoolDemo();
        demo.startTask();
    }

    public void startTask() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Task(i));
        }
    }

    static class Task implements Runnable {
        int index = 0;

        public Task(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
                System.out.println("index : " + index + " thread name : "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
