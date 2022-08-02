package single_invoke_stack.leet_code_32;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 11:28
 * @Desc :32. 最长有效括号 https://leetcode.cn/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses3 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '(') {
                stack.push(i);LongestValidParentheses2
                continue;
            }
            if (currChar == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    // 分段了，需要重新开始
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }


        return res;


    }
}
