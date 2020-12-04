package com.android.java_thread;

/**
 * @author : dev
 * @version :
 * @Date :  11/24/20 7:02 PM
 * @Desc :
 */
public class Stop {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.start();
        System.out.println("t1:" + t1.isInterrupted());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        System.out.println("2: " + t1.isInterrupted());
        try {
            t1.join();
            System.out.println("3:" + t1.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class T1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (true) {
                System.out.println("tttttttt");
            }
        }
    }


}
