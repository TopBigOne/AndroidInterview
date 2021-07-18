package com.jar.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;


/**
 *同步队列，不存储，产生一个消费一个；
 */
public class SynchronousQueueDemo {
    static BlockingQueue<String> blockingDeque = new SynchronousQueue<>();
    public static void main(String[] args) {
        SynchronousQueueDemo synchronousQueueDemo = new SynchronousQueueDemo();
        new Thread(new TaskOne(blockingDeque), "生产线程").start();
        new Thread(new TaskTwo(blockingDeque), "消费线程").start();
    }

    static class TaskOne implements Runnable {
        BlockingQueue<String> blockingDeque;

        public TaskOne(BlockingQueue<String> blockingDeque) {
            this.blockingDeque = blockingDeque;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+" 生产 1");
                blockingDeque.put("1");
                System.out.println(Thread.currentThread().getName()+" 生产 2");
                blockingDeque.put("2");
                System.out.println(Thread.currentThread().getName()+" 生产 3");
                blockingDeque.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class TaskTwo implements Runnable {
        BlockingQueue<String> blockingDeque;

        public TaskTwo(BlockingQueue<String> blockingDeque) {
            this.blockingDeque = blockingDeque;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(3000);
                    String take = blockingDeque.take();
                    System.out.println(Thread.currentThread().getName()+" 消费 "+take);
                    System.out.println("|---------------------------------------|");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}