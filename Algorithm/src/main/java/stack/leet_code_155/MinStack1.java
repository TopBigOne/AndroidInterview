package stack.leet_code_155;

import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : dev
 * @version :
 * @Date :  3/3/21 11:48 PM
 * @Desc :
 */
public class MinStack1 {
    private Stack<Integer> normalStack;
    private Stack<Integer> minStack;

    public MinStack1() {
        normalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        normalStack.push(x);
        if (!minStack.isEmpty()) {
            int top = minStack.peek();
            if (x <= top) {
                minStack.push(x);
            }
        }
        else {
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

    public int top() {
        return normalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
