package single_invoke_stack.leet_code_32;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 11:16
 * @Desc :
 */
public class LongestValidParentheses2 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '(') {
                stack.push(i);
                continue;
            }
            if (currChar == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());

                }
            }
        }
        return res;
    }
}
