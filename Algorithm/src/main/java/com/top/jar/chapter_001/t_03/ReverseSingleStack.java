package com.top.jar.chapter_001.t_03;

import java.util.Stack;
import java.util.function.Consumer;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-18 00:46
 * @Desc :将栈中的元素，逆序，但是只能用递归；
 */
public class ReverseSingleStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        reverse(stack);
        System.out.println("-----反转之后---------");
    }

    private static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int last = getAndRemoveLastElement(stack);
        System.out.println("reverse(): last:" + last);
        reverse(stack);
        stack.push(last);
    }

    /**
     * 将stack 的栈底的元素返回并移除；
     *
     * @param stack
     * @return
     */
    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        // TODO: 2020-06-18   先留着，，，对递归 中的递归，有点消化不了...  By Jakarta
        int popValue = stack.pop();
        // 栈空了，pop 的是栈里的最后一个元素了。
        if (stack.isEmpty()) {
            return popValue;
        }
        int last = getAndRemoveLastElement(stack);
        System.out.println("popValue:" + popValue);
        stack.push(popValue);
        return last;

    }

}


