package stack.leet_code_155;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 18:09
 * @Desc :
 */
public class MinStack7 {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public MinStack7() {

    }

    public void push(int val) {
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);

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

    public void push2(int val) {
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop2() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }
}
