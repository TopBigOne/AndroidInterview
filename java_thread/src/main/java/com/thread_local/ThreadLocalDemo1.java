package com.thread_local;

/**
 * @author : dev
 * @version :
 * @Date :  2022/9/30 12:00
 * @Desc :  线程本地变量
 * 视频讲解：https://www.youtube.com/watch?v=x_PHp-IVPY8
 */
public class ThreadLocalDemo1 {

    static ThreadLocal<Integer> threadLocalOne = new ThreadLocal<>();
    static ThreadLocal<String> threadLocalTwo = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocalDemo1 threadLocalDemo1 = new ThreadLocalDemo1();
        threadLocalDemo1.testOne();

    }

    private void testOne() {
        ThreadOne t1 = new ThreadOne();
        t1.setName("ThreadOne");
        t1.start();
    }

    static class ThreadOne extends Thread {

        @Override
        public void run() {
            threadLocalOne.set(1);
            threadLocalOne.set(2);
            threadLocalOne.set(3);
            int resultOne = threadLocalOne.get();
            System.err.println("resultOne : " + resultOne);

            threadLocalTwo.set("筱雅");
            String resultTwo = threadLocalTwo.get();
            System.err.println("resultTwo : " + resultTwo);

        }
    }


}
