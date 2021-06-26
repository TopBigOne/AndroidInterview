package stack.byte_03_02;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/5 00:34
 * @Desc : 最小栈：请设计一个栈，除了常规栈支持的pop与push函数以外，
 * 还支持min函数，该函数返回栈元素中的最小值。
 * 执行push、pop和min操作的时间复杂度必须为O(1)。
 * <p>
 * 自己的思路：
 * 无论normal 栈如何pop 和 push，min栈都要保证，在外部调用getMin() 函数时，
 * 都要保证，返回的值，和normal 栈中的值，是一样的；
 */
public class MinStack2 {
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int x) {
       normal.push(x);
        if (min.isEmpty()||x<=getMin()) {
            min.push(x);
        }

    }

    public void pop() {
        // 如果出栈的值等于最小值，说明栈中的最小值已经出栈了,
        // 因为min的栈顶元素存放的就是最小值
        // 所以min栈元素 也要出栈
        //  这一步，两个操作
        if (normal.pop()==getMin()) {
            min.pop();
        }
    }


    public int top() {
        return normal.peek();

    }

    public int getMin() {
        return min.peek();
    }

}
