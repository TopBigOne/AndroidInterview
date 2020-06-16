package com.android.java_thread.a1b2c3;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-14 15:26
 * @Desc :
 */
public class T09_00_BlockingQueue {

    private static BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
    private static BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (char c : aI) {
                System.out.print(c);
                try {
                    q1.put("OK");
                    // 当前线程阻塞在此处
                    q2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "t1").start();

        // 我是做android 的，马老师，你建议学吗？

         new Thread(() -> {
            for (char c : aC) {
                try {
                    q1.take();
                    System.out.print(c);
                    q2.put("OK");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "t2").start();

    }

}
