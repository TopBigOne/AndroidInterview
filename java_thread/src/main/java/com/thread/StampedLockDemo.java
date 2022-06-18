package com.thread;

import com.thread.stamped.Point;

import java.util.Random;

/**
 * @author : Jakarta
 * @version :
 * @Date : 7/1/20 8:20 PM
 * @Desc :StampedLock : 读与读不互斥，读写不互斥，写写互斥；
 */
public class StampedLockDemo {

    Thread[] mMoveThreads     = new Thread[100];
    Thread[] mDistanceThreads = new Thread[100];
    Point    mPoint;


    public static void main(String[] args) {
        StampedLockDemo stampedLockDemo = new StampedLockDemo();
        stampedLockDemo.init();
        stampedLockDemo.test();
    }

    private  void test() {
        multipleMove();
        multipleDistanceFromOrigin();
    }


   void init() {
        mPoint = new Point();
        for (int i = 0; i < mMoveThreads.length; i++) {
            Runnable target;
            mMoveThreads[i] = new Thread(new MoveThread());
        }

        for (int i = 0; i < mDistanceThreads.length; i++) {
            Runnable target;
            mDistanceThreads[i] = new Thread(new DistanceThread());
        }
    }


    void multipleMove() {
        for (Thread thread : mMoveThreads) {
            thread.start();
        }
    }

    void multipleDistanceFromOrigin() {
        for (Thread thread : mDistanceThreads) {
            thread.start();
        }
    }


    class MoveThread implements Runnable {
        @Override
        public void run() {
            Random ran1 = new Random();
            double x = ran1.nextDouble();
            double y = ran1.nextDouble();

            System.out.println("x:"+x+", y:"+y);
            mPoint.move(x, y);
        }
    }

    class DistanceThread implements Runnable {
        @Override
        public void run() {
            double result = mPoint.distanceFromOrigin();
            System.out.println("result :" + result);
        }
    }


}
