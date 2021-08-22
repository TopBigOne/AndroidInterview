package stack.leet_code_20;

import java.util.ArrayDeque;

/**
 * @author : dev
 * @version :
 * @Date :  8/11/21 11:29 PM
 * @Desc : leetcode 20 ： 有效括号：https://leetcode-cn.com/problems/valid-parentheses/
 * <p>
 * 题解：https://www.youtube.com/watch?v=o7lQWD8FiIA
 */
public class IsValid3 {
    public static void main(String[] args) {
        String strs = "()";
        IsValid3 isValid3 = new IsValid3();
        boolean result = isValid3.isValid(strs);
        System.out.println("result : " + result);
    }

    public boolean isValid(String s) {
        int len;
        // 1: base corner.
        if (s == null || (len = s.length()) == 0 || (len & 1) == 0) {
            return false;
        }
        // ( ) { } [ ]
        ArrayDeque<Character> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 1
            if (c == '(' ||
                    c == '{' ||
                    c == '[') {
                // 在尾部添加
//                stack.offer(c);
                stack.addFirst(c);
                continue;
            }
            if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.poll();
                continue;
            }
            if (!stack.isEmpty() && c == '}' && stack.peek() == '{') {
                stack.poll();
                continue;
            }
            if (!stack.isEmpty() && c == ']' && stack.peek() == '[') {
                stack.poll();
                continue;
            }
            // 以上三种条件都没有满足，直接返回 false；
            return false;
        }
        return stack.isEmpty();


    }
}
