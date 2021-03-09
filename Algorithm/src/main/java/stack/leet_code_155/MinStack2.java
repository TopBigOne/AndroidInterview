package stack.leet_code_155;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  3/4/21 12:23 AM
 * @Desc :
 */
public class MinStack2 {
    private Stack<Integer> normalStack;
    private Stack<Integer> minStack;

    public MinStack2() {
        this.normalStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        normalStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
            return;
        }

        int top = minStack.peek();
        if (x <= top) {
            minStack.push(x);
        }
    }

    public void pop() {
        int pop = normalStack.pop();
        int top = minStack.peek();
        if (pop == top) {
            minStack.pop();
        }
    }

    private int top() {
        return normalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
