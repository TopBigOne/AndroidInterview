package com.thread.reentrant;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author : 周广亚
 * @version :
 * @Date :  2023/4/29 18:25
 * @Desc :
 */


public class DecoderTask extends FlowControl {

    LinkedList<byte[]> queue;


    private volatile ReentrantLock lock = null;
    private volatile Condition consumer = null;
    private volatile Condition producer = null;

    public DecoderTask(LinkedList<byte[]> queue, ReentrantLock lock, Condition consumer, Condition producer, boolean mIsDecoderOver) {
        this.queue = queue;
        this.lock = lock;
        this.consumer = consumer;
        this.producer = producer;
    }

    @Override
    Condition getConsumerCondition() {
        return consumer;
    }

    @Override
    Condition getProducerCondition() {
        return producer;
    }

    @Override
    ReentrantLock getReentrantLock() {
        return lock;
    }


    @Override
    LinkedList<byte[]> getCommonQueue() {
        return queue;

    }

    int count = 0;
    private static final String TAG = "DecoderTask : ";

    public void startDecoderTask() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (count == 3) {
                            getReentrantLock().lock();
                            TaskManager.mIsDecoderOver = true;
                            getConsumerCondition().signalAll();
                            getReentrantLock().unlock();
                            Log.e(TAG, "        startDecoderTask : 👌👌👌👌解码线程完成工作了. " + getCommonQueue().size());
                            break;
                        }

                        putByte(new byte[2]);
                        count++;
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        // getReentrantLock().unlock();
                    }

                }
            }
        }, "DecoderTask-thread").start();
    }
}



