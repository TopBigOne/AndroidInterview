package stack.byte_03_02;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/22 21:34
 * @Url :
 * @Level :  easy
 * @Desc : 最小栈：无论调用top() ,pop(),push(),都要保证stack的栈顶，min元素最小；
 * （半年内，字节出现了5次）栈的最小值：https://leetcode-cn.com/problems/min-stack-lcci/submissions/
 * @Counter :
 * @Answer :
 */
public class MinStack4 {
    Deque<Integer> stack = new ArrayDeque<>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        if (x <=min) {
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
