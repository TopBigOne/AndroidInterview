package stack.byte_03_02;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/22 21:25
 * @Url :
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class MinStack3 {
    private final Deque<Integer> stack = new ArrayDeque<>();
    private int min = Integer.MIN_VALUE;

    public void push(int x) {
        if (x < min) {
            stack.push(min);
            min = x;
        }
        stack.push(min);
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
