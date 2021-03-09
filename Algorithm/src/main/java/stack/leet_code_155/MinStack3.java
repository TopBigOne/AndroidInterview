package stack.leet_code_155;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  3/4/21 12:35 AM
 * @Desc : 最小栈
 *
 * 题解：(https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/)
 */
public class MinStack3 {
    private Stack<Integer> normalStack;
    private Stack<Integer> minStack;

    public MinStack3(){
        normalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x){
        normalStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
            return;
        }
        int top = minStack.peek();
        if (x<=top) {
            minStack.push(x);
        }
    }

    public  void pop(){
        int pop = normalStack.pop();

        int top = minStack.peek();
        if (pop==top) {
            minStack.pop();
        }
    }

    public int top(){
        return normalStack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

}
