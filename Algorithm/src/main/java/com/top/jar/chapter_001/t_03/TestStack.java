package com.top.jar.chapter_001.t_03;

import java.util.Stack;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-18 02:02
 * @Desc :
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        System.out.println("stack size:"+stack.size());

    }
}
