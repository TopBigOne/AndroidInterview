package com.jar.lock;

import org.omg.CORBA.IRObject;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : dev
 * @version :
 * @Date :  7/31/21 8:41 PM
 * @Desc :
 */
public class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putPtr;
    int takePtr;
    int count;

    public void put(Object x) {
        try {
            lock.lock();
            while (count == items.length) {
                notFull.await();
                items[putPtr] = x;
                if (++putPtr == items.length) putPtr = 0;
                ++count;
                notEmpty.signal();
            }
        } catch (InterruptedException e) {
            lock.unlock();
            e.printStackTrace();
        }
    }


    public Object take() {
        try {
            lock.lock();
            while (count == 0) {
                notEmpty.await();
                Object x = items[takePtr];
                if (++takePtr == items.length) {
                    takePtr = 0;
                }
                --count;
                notEmpty.signal();
                return x;


            }
        } catch (InterruptedException e) {
            lock.unlock();
            e.printStackTrace();
        }
        return null;


    }


}
