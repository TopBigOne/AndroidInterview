package com.thread.thread_pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/3 00:25
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 * https://qiita.com/opengl-8080/items/ee8e926cf75e4d6058a2  一个日本大佬写的；
 */
public class NewScheduledThreadPool {

    public static void main(String[] args) {
        NewScheduledThreadPool demo = new NewScheduledThreadPool();
        demo.startTask();
    }

    public void startTask() {
        AtomicInteger number = new AtomicInteger();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        Task task = new Task(number);
        service.scheduleAtFixedRate(task, 2, 2, TimeUnit.SECONDS);
        int count = 0;
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println((++count) + " s");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class Task implements Runnable {
        AtomicInteger number;

        public Task(AtomicInteger number) {
            this.number = number;
        }

        @Override
        public void run() {
            try {
                int n = number.getAndIncrement();
                System.out.println("begin(" + n + ")");
                Thread.sleep(Math.max(1, 3 - n));
                System.out.println("end(" + n + ")");
                System.out.println("                     ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
