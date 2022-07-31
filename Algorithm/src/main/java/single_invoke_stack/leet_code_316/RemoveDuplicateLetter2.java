package single_invoke_stack.leet_code_316;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 00:12
 * @Desc : leetcode 316 ： 去除重复字母 https://leetcode.cn/problems/remove-duplicate-letters/
 * 1: 去掉重复字符；
 * 2：保证 最后字符的字典序最小
 */
public class RemoveDuplicateLetter2 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character currChar = s.charAt(i);
            if (stack.contains(currChar)) {
                continue;
            }

            // 1:遇到一个新字符 如果比栈顶小
            // 2:并且在新字符后面还有和栈顶一样的 就把栈顶的字符抛弃了
            while (!stack.isEmpty() && currChar < stack.peek() && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(currChar);
        }

        char[] chars = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            chars[i] = stack.get(i);
        }
        return new String(chars);
    }

    public String removeDuplicateLetters2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character currChar = s.charAt(i);
            if (stack.contains(currChar)) {
                continue;
            }
            while (!stack.isEmpty() && currChar < stack.peek() && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(currChar);
        }
        char[] chars = new char[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            chars[i] = stack.get(i);
        }
        return new String(chars);
    }

}
