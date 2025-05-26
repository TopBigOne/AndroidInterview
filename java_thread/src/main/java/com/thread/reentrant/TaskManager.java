package com.thread.reentrant;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2023/4/29 19:20
 * @Desc :
 */

public class TaskManager {
    private volatile LinkedList<byte[]> queue;
    private DecoderTask decoderTask;
    private EncoderTask encoderTask;

    private volatile  ReentrantLock lock = null;
    private volatile  Condition consumer = null;
    private volatile   Condition producer = null;

    public static volatile boolean mIsDecoderOver = false;

   volatile boolean  isDecoderOver = false;
    public TaskManager() {
        this.queue = new LinkedList<>();
        lock = new ReentrantLock();
        consumer = lock.newCondition();
        producer = lock.newCondition();

        decoderTask = new DecoderTask(queue, lock, consumer, producer,isDecoderOver);
        encoderTask = new EncoderTask(queue, lock, consumer, producer,isDecoderOver);
    }

    public void startAllTask() {
        decoderTask.startDecoderTask();
        encoderTask.startEncoderTask();
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.startAllTask();

    }
}
