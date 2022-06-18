package com.thread.java_thread.a1b2c3;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-12 01:06
 * @Desc :
 * 来解释一下，首先第一个我先调用wait、notify的时候，wait线程阻塞，notify叫醒其他线程，
 * 调用这个 两个方法的时候必须要进行synchronized锁定的，如果没有synchronized这个线程你是锁定不了的，
 * 他是离开不锁的，因此我们定义一个锁的对象new Object()，两个数组，第一线程上来先锁定Object对 象 o，
 * 锁定完对象之后，我们开始输出，输出第一个数字，输出完之后叫醒第二个，然后自己wait。还 是这个思路，
 * 其实这个就和LookSupport的park、unpark是非常类似的，
 * 这里面最容易出错的一个地 方就是把整个数组都打印完了要记得notify，为什么要notify啊，
 * 因为这两个线程里面终归有一个线程 wait的，是阻塞在这停止不动的。
 */
public class T06_00_sync_wait_notify {
    public static void main(String[] args) {
       final   Object o = new Object();
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {
            synchronized (o) {
                for (char c : aI) {
                    System.out.print(c);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, "t1").start();


          new Thread(() -> {
            synchronized (o) {
                for (char c : aC) {
                    System.out.print(c);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

              //  o.notify();

            }

        }, "t2").start();

    }




}
