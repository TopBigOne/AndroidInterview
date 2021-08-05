package stack.byte_03_02;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/23 10:36
 * @Url :
 * @Level :  easy
 * @Desc : （半年内，字节出现了5次）栈的最小值：https://leetcode-cn.com/problems/min-stack-lcci/submissions/
 * @Counter :
 * @Answer :
 */
public class MinStack5 {
    Deque<Integer> stack = new ArrayDeque<>();
    int min = Integer.MAX_VALUE;

    public void push(int x){
        if(x<=min){
            stack.push(min);
            min = x;

        }
        stack.push(x);
    }

    public void  pop(){
        if(stack.pop()==min){
            min = stack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return min;

    }


}
