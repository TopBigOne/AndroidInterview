package stack.leet_code_20;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : dev
 * @version :
 * @Date :  7/8/21 12:10 AM
 * @Desc : leetcode 20 ： 有效括号：https://leetcode-cn.com/problems/valid-parentheses/
 * <p>
 * 题解：https://www.youtube.com/watch?v=o7lQWD8FiIA
 */
public class IsValid2 {
    public boolean isValid(String s) {
        int len;
        // base corner
        if (s == null || (len = s.length()) == 0 || (len & 1) == 1) {
            return false;
        }

        // '('，')'，'{'，'}'，'['，']'
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 1:左边的符号，就做 push 操作
            if (c == '(' ||
                    c == '{' ||
                    c == '[') {
                stack.push(c);
                continue;
            }

            // 2: 判断与右边的 字符能否匹配上；（为了邂逅啊...）
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
                continue;
            }
            if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
                continue;
            }

            // 以上 3 个 if 都没有匹配好的话，那还有什么可谈的，，，分手，，分手，，，你就是不配，，，
            return false;

        }

        // 栈，是否为空，空的话，就 ok 啦，，
        return stack.isEmpty();
    }

    public boolean isValid2(String str) {
        int len;
        // 1: base corner.
        if (str == null || (len = str.length()) == 0 || (len & 1) == 1) {
            return false;
        }
        // 2:put and check.
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char currChar = str.charAt(i);

            if (currChar == '(' ||
                    currChar == '[' ||
                    currChar == '{') {
                stack.push(currChar);
                continue;
            }


            if (!stack.isEmpty() && currChar == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            if (!stack.isEmpty() && currChar == ']' && stack.peek() == '[') {
                stack.pop();
                continue;
            }
            if (!stack.isEmpty() && currChar == '}' && stack.peek() == '{') {
                stack.pop();
                continue;
            }

            return false;

        }

        return stack.isEmpty();


    }

    public boolean isValid3(String s) {
        int len;
        // base corner
        if (s == null || (len = s.length()) == 0 || (len & 1) == 1) {
            return false;
        }

        // '('，')'，'{'，'}'，'['，']'
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 1:左边的符号，就做 push 操作
            if (c == '(' ||
                    c == '{' ||
                    c == '[') {
                stack.push(c);
                continue;
            }

            // 2: 判断与右边的 字符能否匹配上；（为了邂逅啊...）

            if (!stack.isEmpty()) {
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
                if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
            }
            // 以上 3 个 if 都没有匹配好的话，那还有什么可谈的，，，分手，，分手，，，你就是不配，，，
            return false;

        }

        // 栈，是否为空，空的话，就 ok 啦，，
        return stack.isEmpty();
    }


}
