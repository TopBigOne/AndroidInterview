package stack.leet_code_232;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  3/4/21 10:16 PM
 * @Desc : 用栈实现一个队列（https://leetcode-cn.com/problems/implement-queue-using-stacks/）
 */
public class MyQueueByStack {

    private Stack<Integer> normal;
    private Stack<Integer> reverse;

    public MyQueueByStack() {
        normal = new Stack<>();
        reverse = new Stack<>();
    }

    public void push(int x) {
        normal.push(x);
    }

    public int pop() {
        if (reverse.isEmpty()) {
            while (!normal.isEmpty()) {
                reverse.push(normal.pop());
            }
        }
        return reverse.pop();

    }

    public int peek() {
        if (reverse.isEmpty()) {
            while (!normal.isEmpty()) {
                reverse.push(normal.pop());
            }
        }
        return reverse.peek();
    }

    public boolean empty() {
        return reverse.isEmpty()&&normal.isEmpty();
    }
}
