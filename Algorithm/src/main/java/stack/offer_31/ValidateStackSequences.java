package stack.offer_31;

import java.util.Stack;

/**
 * @author : dev
 * @version : 剑指 Offer 31. 栈的压入、弹出序列
 * @Date :  2022/6/15 15:44
 * @Desc :  https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 */
public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        boolean result = validateStackSequences.validateStackSequences(pushed, popped);
        System.err.println("result : " + result);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            // num 入栈
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }

        }
        return stack.isEmpty();


    }
}
