package com.android.stamped;

import java.util.concurrent.locks.StampedLock;

/**
 * @author : Jakarta
 * @version :
 * @Date : 7/1/20 8:25 PM
 * @Desc :1:多线程调用 move 函数，修改坐标；
 * 2: 多线程调用 distanceOrigin()函数，求距离
 */
public class Point {
    private double x, y;
    private final StampedLock sl = new StampedLock();

    /**
     * 多个线程调用该函数，修改x，y；
     *
     * @param x
     * @param y
     */
    public void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    public double distanceFromOrigin() {
        // 乐观锁,将共享变量 copy 到线程栈，读的期间有其他线程修改数据，
        // 读的是脏数据，放弃
        // 升级为悲观锁；
        long stamp = sl.tryOptimisticRead();
        double currentX = x, currentY = y;

        if (!sl.validate(stamp)) {
            stamp = sl.readLock();

            try {
                currentX = x;
                currentY = y;
            } catch (Exception e) {
                System.out.println("Point——Exception：" + e.getMessage());
            } finally {
                sl.unlockRead(stamp);
            }
        }

        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
