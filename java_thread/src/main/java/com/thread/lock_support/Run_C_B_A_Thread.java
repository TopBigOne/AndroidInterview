package com.thread.lock_support;

import java.util.concurrent.locks.LockSupport;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2022/12/24 16:04
 * @Desc : 采华问我的线程交替执行；
 */
public class Run_C_B_A_Thread {
    static ThreadA threadA = new ThreadA();
    static ThreadB threadB = new ThreadB();
    static ThreadC threadC = new ThreadC();

    public static void main(String[] args) {
        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            super.run();
            LockSupport.park();
            System.out.println(" run thread A");
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            super.run();
            LockSupport.park();
            System.out.println(" run thread B");
            LockSupport.unpark(threadA);
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(" run thread C");
            LockSupport.unpark(threadB);
        }
    }


}
