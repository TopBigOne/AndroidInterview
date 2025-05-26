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


public class EncoderTask extends FlowControl {
    private static final String TAG = "EncoderTask : ";

    LinkedList<byte[]> queue;


    private volatile ReentrantLock lock = null;
    private volatile Condition consumer = null;
    private volatile Condition producer = null;


    public EncoderTask(LinkedList<byte[]> queue, ReentrantLock lock, Condition consumer, Condition producer, boolean isDecoderOver) {
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

    public void startEncoderTask() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (getCommonQueue().isEmpty() && TaskManager.mIsDecoderOver) {
                        Log.d(TAG, "startEncoderTask: 队列为空了，并且，解码线程也结束了，" +
                                "编码线程已经消耗完所有的数据，所以也可以结束了.");
                        return;
                    }
                    Log.e(TAG, "                            invoke takeByte ");
                    byte[] bytes = takeByte();
                }

            }
        }, "EncoderTask-thread").start();

    }
}
