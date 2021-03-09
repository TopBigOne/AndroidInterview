package stack.leet_code_155;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  3/4/21 2:30 PM
 * @Desc :
 */
public class MinStack5 {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
