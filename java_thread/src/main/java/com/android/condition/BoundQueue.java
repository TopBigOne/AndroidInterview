package com.android.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : dev
 * @version :
 * @Date :  1/27/21 6:48 PM
 * @Desc : 队列为空时，队列的操作就会阻塞 获取线程，直到队列中有数据，当队列已经满了，队列的插入
 * 将会插入线程，直到队列出现"空位"
 */
public class BoundQueue<T> {
    private Object[] items;
    private int addIndex;
    private int removeIndex;
    private int count;
    private Lock mLock = new ReentrantLock();
    private Condition notEmpty = mLock.newCondition();
    private Condition notFull = mLock.newCondition();

    public BoundQueue(int size) {
        items = new Object[size];
    }

    public void add(T t) {
        mLock.lock();
        while (count == items.length) {
            try {
                notFull.await();
                items[addIndex] = t;
                if (++addIndex == items.length) {
                    addIndex = 0;
                }
                ++count;
                notEmpty.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mLock.unlock();
            }
        }
    }

    public T remove() {
        mLock.lock();
        while (count == 0) {
            try {
                notEmpty.await();
                Object x = items[removeIndex];
                if (++removeIndex == items.length) {
                    removeIndex = 0;
                }
                --count;
                notFull.signal();
                return (T) x;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mLock.unlock();
            }

        }
        return null;
    }

}
