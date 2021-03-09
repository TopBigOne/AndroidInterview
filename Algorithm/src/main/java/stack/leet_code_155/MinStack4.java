package stack.leet_code_155;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  3/4/21 11:47 AM
 * @Desc :
 */
public class MinStack4 {
    private Stack<Integer> normalStack;
    private Stack<Integer> minStack;

    public MinStack4(){
        normalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x){
        normalStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
            return;
        }



    }

    private  void pop(){
        int pop = normalStack.pop();
        int top = minStack.peek();
        if (pop==top) {
            normalStack.pop();
        }
    }


    public int top(){
        return normalStack.peek();
    }


    public int getMin(){
        return minStack.peek();
    }
}
