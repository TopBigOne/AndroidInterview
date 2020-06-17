package com.top.jar.chapter_001.t_02;

import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-16 23:01
 * @Desc : 编写一个类，用两个 stack 实现队列，支持队列的基本操作（add,poll,peek）
 */
public class TwoStackQueue {
    Stack<Integer> mStackOne, mStackTwo;

    public TwoStackQueue() {
        mStackOne = new Stack<>();

        mStackTwo = new Stack<>();
    }


    public void add(int newNum) {
        mStackOne.push(newNum);
        while (!mStackOne.isEmpty()) {
            int popValue = mStackOne.pop();
            mStackTwo.add(popValue);
        }

    }

    public void printStackOne() {
        mStackOne.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("push integer :" + integer);
            }
        });

    }

    /**
     * 返回队列头..
     *
     * @return
     */
    private int poll() {
        return mStackTwo.pop();
    }


    /**
     * 返回队列头最前面的一个值，不删除。；
     *
     * @return
     */
    private int peek() {
        return mStackTwo.peek();
    }

    private int getStackOneSize() {
        return mStackOne.size();
    }

    private int getQueueSize() {

        return mStackTwo.size();
    }


    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.add(1);
        twoStackQueue.add(2);
        twoStackQueue.add(3);

        System.out.println("--------twoStackQueue size :" + twoStackQueue.getQueueSize());
        System.out.println(" the first value is 3 :" + twoStackQueue.poll());
        System.out.println(" the peek value is  2 :" + twoStackQueue.peek());


    }


}
