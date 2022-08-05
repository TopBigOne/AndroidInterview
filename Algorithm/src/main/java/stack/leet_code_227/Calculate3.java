package stack.leet_code_227;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/5 14:42
 * @Desc :
 */
public class Calculate3 {
    public int calculate(String s) {
        s = s.replace(" ", "");
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int currNum = 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {

            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNum = currChar - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    currNum = currNum * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
            }

            if (!Character.isDigit(currChar) || i == len - 1) {
                if (sign == '+') {
                    stack.push(currNum);
                }
                if (sign == '-') {
                    stack.push(-currNum);
                }

                if (sign == '*') {
                    stack.push(stack.pop() * currNum);
                }

                if (sign == '/') {
                    stack.push(stack.pop() / currNum);
                }
                sign = currChar;
                currNum = 0;
            }
        }

        //最后进行计算
        for (Integer integer : stack) {
            res += integer;
        }
        return res;
    }

    public int calculate2(String s) {
        if (s == null) {
            return 0;
        }
        s = s.replace(" ", "");
        int len;
        if ((len = s.length()) == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        int res = 0;
        int currNum = 0;
        for (int i = 0; i < len; i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNum = currChar - '0';
                char nextChar;
                while (i + 1 < len && Character.isDigit((nextChar = s.charAt(i + 1)))) {
                    currNum = currNum * 10 + nextChar - '0';
                    i++;
                }
            }

            if (!Character.isDigit(currChar) || i == len - 1) {
                if (sign == '+') {
                    stack.push(currNum);
                }
                if (sign == '-') {
                    stack.push(-currNum);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * currNum);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / currNum);
                }

                sign = currChar;
                currNum = 0;
            }
        }

        for (Integer integer : stack) {
            res += integer;
        }

        return res;

    }
}
