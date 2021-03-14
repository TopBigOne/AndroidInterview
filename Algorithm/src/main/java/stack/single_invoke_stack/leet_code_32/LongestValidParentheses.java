package stack.single_invoke_stack.leet_code_32;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  3/14/21 7:50 PM
 * @Desc : 最长有效括号（https://leetcode-cn.com/problems/longest-valid-parentheses/）
 * 题解：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/javadai-ma-de-ji-chong-jie-fa-by-sdwwld/
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 */
public class LongestValidParentheses {
    /**
     * 如果遇到左括号我们就把他的下标压栈，如果遇到右括号说明和栈顶元素匹配，
     * 那么栈顶元素比如m出栈，用当前元素的下标减去新的栈顶元素的值，
     * 为什么减去新的栈顶元素值，这是因为新的栈顶元素还没匹配成功，
     * 之前的栈顶元素m到现在元素的下标之间构成了有效的括号
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }
            stack.pop();
            if (stack.empty()) {
                stack.push(i);
                continue;
            }
            max = Math.max(max, i - stack.peek());
        }
        return max;
    }

}
