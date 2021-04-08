package stack.byte_30;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/31 10:56
 * @Desc :  半年之内，字节：11次；最小栈： https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/
 * 题解：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/jian-zhi-offer-30-bao-han-minhan-shu-de-zhan-tu-we/
 */
public class MinStack {
    Stack<Integer> normalStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        normalStack.push(x);
        if (minStack.isEmpty() || x <= min()) {
            minStack.push(x);
        }
    }

    public void pop() {
        // 如果出栈的值等于最小值，说明栈中的最小值已经出栈了，
        // 因为minStack 中的栈顶元素存放的就是最小值；
        // 所以minStack栈顶的元素也要出栈
        if (normalStack.pop() == min()) {
            minStack.pop();
        }
    }

    public int top() {
        return normalStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
