package stack.leet_code_1021;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/2 20:23
 * @Desc : 1021 : 删除最外层的括号
 * <p>
 * 题解：https://leetcode-cn.com/problems/remove-outermost-parentheses/solution/chao-xiang-xi-ti-jie-si-lu-jie-zhu-zhan-yuan-yu-hu/
 *
 * <p>
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 */
public class RemoveOuterParentheses {
    public String removeOuterParentheses(String s) {
        char leftBracket = '(';
        char rightBracket = ')';
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            // 左边的括号
            char currentChar = s.charAt(i);
            if (currentChar == leftBracket) {
                stack.push(leftBracket);
                continue;
            }
            // 右边的括号
            if (currentChar == rightBracket) {
                stack.pop();
                if (stack.isEmpty()) {
                    sb.append(s.substring(start + 1, i));
                    start = i + 1;
                }
            }
        }
        return sb.toString();
    }

    public String removeOuterParentheses2(String s) {
        char leftBracket = '(';
        char rightBracket = ')';
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = sb.charAt(i);
            if (currentChar == leftBracket) {
                stack.push(leftBracket);
                continue;
            }
            // 右边的括号
            if (currentChar == rightBracket) {
                stack.pop();
                if (stack.isEmpty()) {
                    sb.append(s, start + 1, i);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 删除最外层的括号
     *
     * @param s
     * @return
     */
    public String removeOuterParentheses3(String s) {
        char leftBracket = '(';
        char rightBracket = ')';
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = sb.charAt(i);
            if (currentChar == leftBracket) {
                stack.push(leftBracket);
                continue;
            }

            if (currentChar == rightBracket) {
                stack.pop();
                if (stack.isEmpty()) {
                    sb.append(s, start + 1, i);
                    start = i+1;
                }
            }
        }
        return sb.toString();
    }


    public String removeOuterParentheses4(String s) {
        char leftBracket = '(';
        char rightBracket = ')';
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == leftBracket) {
                stack.push(leftBracket);
                continue;
            }
            if (currentChar == rightBracket) {
                stack.pop();
                if (stack.isEmpty()) {
                    sb.append(s, start + 1, i);
                    start = i+1;
                }
            }

        }
        return sb.toString();

    }


}
