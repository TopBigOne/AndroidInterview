package com.android.java_thread.juc.condition;

/**
 * @author : dev
 * @version :
 * @Date :  1/27/21 6:48 PM
 * @Desc : 队列为空时，队列的操作就会阻塞 获取线程，直到队列中有数据，当队列已经满了，队列的插入
 * 将会插入线程，直到队列出现"空位"
 */
public class BoundQueue <T>{
    private Object [] items;
    private int addIndex;
}
