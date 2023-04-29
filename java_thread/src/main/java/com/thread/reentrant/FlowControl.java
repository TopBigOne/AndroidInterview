package com.thread.reentrant;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author : 周广亚
 * @version :
 * @Date :  2023/4/29 18:22
 * @Desc :
 */
public abstract class FlowControl {
    private static final String TAG = "FlowControl : ";

    //private volatile LinkedList<byte[]> byteQueue;

    private static final int QUEUE_LIME_SIZE = 3;

    public FlowControl() {
    }

    /**
     * 数据
     *
     * @return
     */
    abstract Condition getConsumerCondition();

    abstract Condition getProducerCondition();

    abstract ReentrantLock getReentrantLock();

    abstract LinkedList<byte[]> getCommonQueue();

    public byte[] takeByte() {
        byte[] result = null;
        getReentrantLock().lock();
        try {

            if (getCommonQueue().isEmpty()) {
                if (TaskManager.mIsDecoderOver) {
                    Log.e(TAG, "        takeByte : mIsDecoderOver is TRUE：" + getCommonQueue().size());
                    return null;
                }
                Log.e(TAG, "        takeByte : 队列空的 编码线程 在等待，当前 队列大小：" + getCommonQueue().size());
                getConsumerCondition().await();
            }

            if (getCommonQueue().peekFirst() != null) {
                result = getCommonQueue().removeFirst();
            }

            getProducerCondition().signalAll();
            Log.e(TAG, "        takeByte :   tell解码线程，可以工作，当前 队列大小：" + getCommonQueue().size());
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            getReentrantLock().unlock();
        }
        return null;
    }


    public void putByte(byte[] data) {
        Log.d(TAG, "putByte : thread is : " + Thread.currentThread().getName());
        getReentrantLock().lock();
        try {
            if (getCommonQueue().size() >= QUEUE_LIME_SIZE) {
                Log.e(TAG, "        putByte :   队列满了，解码线程在等待，当前 队列大小：" + getCommonQueue().size());
                getProducerCondition().await();
            }
            getCommonQueue().addLast(data);
            Log.e(TAG, "        putByte :  往队列中添加了一条数据，当前 队列大小：" + getCommonQueue().size());
            Log.e(TAG, "        putByte :   📢📢📢📢通 知编码线程，可以工作了 ，当前 队列大小：" + getCommonQueue().size());
            getConsumerCondition().signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            getReentrantLock().unlock();
        }
    }
}

