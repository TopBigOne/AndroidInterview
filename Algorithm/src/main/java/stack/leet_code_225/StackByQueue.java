package stack.leet_code_225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : dev
 * @version :
 * @Date :  3/4/21 10:05 PM
 * @Desc : 用队列实现一个栈
 */
public class StackByQueue {
    private LinkedList<Integer> queue;

    public StackByQueue() {
        this.queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

       return queue.pollLast();
    }

    /** Get the top element. */
    public int top() {
        return queue.peekLast();

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();

    }
}
