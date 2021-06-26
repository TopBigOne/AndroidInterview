package stack.byte_03_04;

import java.util.Stack;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/22 19:06
 * @Url : https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/
 * @Level : easy medium hard
 * @Desc : 化栈为队列
 * @Counter : 2
 * @Answer :
 */
public class MyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        int peek = myQueue.peek();
        int pop = myQueue.pop();
        System.out.println("peek : " + peek);
        System.out.println("pop  : " + pop);

    }

    private Stack<Integer> input;
    private Stack<Integer> output;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (output.isEmpty()) {
            in2out();
        }
        return output.pop();
    }

    private void in2out() {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        // 判断非空很重要
        if (output.isEmpty()) {
            in2out();
        }
        return output.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return output.isEmpty() && input.isEmpty();
    }

}
