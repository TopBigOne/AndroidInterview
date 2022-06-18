package com.thread.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/3 00:20
 * @Url :
 * @Level :  easy  medium hard
 * @Desc : 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程；
 * 那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，
 * 此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制
 * ，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
 * @Counter :
 * @Answer :
 * <p>
 * 要命的是线程池中线程的最大数量是：Integer.MAX_VALUE，容易发生OOM
 */
public class NewCachedThreadPool {

    public static void main(String[] args) {
        NewCachedThreadPool demo = new NewCachedThreadPool();
        demo.startTask();
    }

    public void startTask() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Task(i));
        }
        for (int i = 200; i < 300; i++) {
            executorService.execute(new Task(i));
        }
        for (int i = 300; i < 400; i++) {
            executorService.execute(new Task(i));
        }
        for (int i = 400; i < 500; i++) {
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
                Thread.sleep(100000);
                System.out.println("index:" + index);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
