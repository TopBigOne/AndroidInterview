package com.top.jar.chapter_001.t_01;

import java.util.Stack;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-16 22:27
 * @Desc :
 */
public class MyStack2 {
    private Stack<Integer> mStackData, mStackMin;

    public MyStack2() {
        mStackData = new Stack<>();
        mStackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (mStackMin.isEmpty()) {
            mStackMin.push(newNum);
        } else if (newNum < getMin()) {
            mStackMin.push(newNum);
        } else {
            int newMin = mStackMin.peek();
            mStackMin.push(newMin);
        }

        mStackData.push(newNum);

    }

    public int pop() {
        if (mStackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }

        mStackMin.pop();
        return mStackData.pop();
    }


    /**
     * 栈顶永远是最小的。
     *
     * @return
     */
    private int getMin() {
        if (mStackMin.isEmpty()) {
            throw new RuntimeException(" your stack is empty.");
        }

        mStackMin.peek();
        return 0;
    }



}
