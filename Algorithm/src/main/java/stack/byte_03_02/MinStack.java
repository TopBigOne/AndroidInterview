package stack.byte_03_02;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/5 00:19
 * @Desc : （半年内，字节出现了5次）栈的最小值：https://leetcode-cn.com/problems/min-stack-lcci/submissions/
 *
 * 题解：https://leetcode-cn.com/problems/min-stack-lcci/solution/dan-ge-zhan-he-shuang-zhan-gong-3chong-jie-jue-fan/
 */
public class MinStack {
    //栈1存放的是需要压栈的值
    Stack<Integer> normal = new Stack<>();
    //栈2存放的是最小值
    Stack<Integer> min = new Stack<>();

    public void push(int x) {
        normal.push(x);
        if (min.empty() || x <= getMin())
            min.push(x);
    }

    public void pop() {
        //如果出栈的值等于最小值，说明栈中的最小值
        //已经出栈了，因为min中的栈顶元素存放的
        //就是最小值，所以min栈顶元素也要出栈
        if (normal.pop() == getMin())
            min.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int getMin() {
        return min.peek();
    }

}
