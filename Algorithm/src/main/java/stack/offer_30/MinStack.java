package stack.offer_30;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/23 15:56
 * @Desc :
 */
public class MinStack {
    Stack<Integer> normalStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        normalStack.push(x);
        if (minStack.isEmpty() || x <= min()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (normalStack.pop() == min()) {
            minStack.pop();
        }
    }

    public int top(){
        return normalStack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
