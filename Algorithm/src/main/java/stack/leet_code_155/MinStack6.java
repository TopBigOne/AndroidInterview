package stack.leet_code_155;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  3/4/21 2:42 PM
 * @Desc :
 */
public class MinStack6 {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    private void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // 直接在if中，做一个普通的出栈操作
        if (stack.pop() == min) {
            // 将最小的出栈
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
