package com.top.jar.chapter_001;

import java.util.Stack;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-15 00:31
 * @Desc :  设计有 getMin 功能的栈
 */
public class MyStack1 {
    private Stack<Integer> mStackData, mStackMin;

    public MyStack1() {
        mStackData = new Stack<>();
        mStackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (mStackMin.isEmpty()) {
            mStackMin.push(newNum);
            return;
        }
        if (newNum <= getMin()) {
            mStackMin.push(newNum);
            return;
        }
        mStackData.push(newNum);
    }

    private int getMin() {
        if (mStackMin.isEmpty()) {
            throw new RuntimeException(" Your stack is empty.");
        }
        return mStackMin.peek();
    }


    private int pop() {
        if (mStackData.isEmpty()) {
            throw new RuntimeException(" Your stack is empty.");
        }

        int pop = mStackData.pop();
        if (pop == getMin()) {
            mStackMin.pop();
        }

        return pop;
    }
}
