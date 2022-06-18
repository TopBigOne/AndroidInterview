package com.thread;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/16 16:36
 * @Desc :
 */
public class AddShutdownHook {
    public static void main(String[] args) {
        System.err.println(" start add shutdown hook...1");
        try {
            // register Message as shutdown hook
            Runtime.getRuntime().addShutdownHook(new Message());
            // print the state of the program
            System.err.println("Program is starting...2");

            // cause thread to sleep for 3 seconds
            // System.err.println("Waiting for 3 seconds...");
            // Thread.sleep(3000);


            // print that the program is closing
            System.err.println(" the main thread program is closing...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static class Message extends Thread {
        public Message() {
            super("筱雅 thread");
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 10; i++) {
                System.err.println("筱雅..... thread name : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
