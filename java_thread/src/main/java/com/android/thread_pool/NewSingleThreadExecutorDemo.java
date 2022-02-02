package com.android.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : dev
 * @version :
 * @Date :  2022/2/2 23:57
 * @Desc :创建一个单线程的线程池。这个线程池只有一个线程在工作，
 * 也就是相当于单线程串行执行所有任务。如果这个唯一的线程因为异常结束，
 * 那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
 */
public class NewSingleThreadExecutorDemo {
    public static void main(String[] args) {
        NewSingleThreadExecutorDemo demo = new NewSingleThreadExecutorDemo();
        demo.startTask();
    }

    public void startTask() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
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
                System.out.println("index:" + index);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
