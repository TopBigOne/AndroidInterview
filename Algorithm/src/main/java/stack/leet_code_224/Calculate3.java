package stack.leet_code_224;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/10 16:38
 * @Desc :
 */
public class Calculate3 {
    public int calculate(String s) {
        s = s.replace(" ", "");
        int len = s.length();
        int sign = 1;
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> signStack = new Stack<>();
        int res = 0;
        for (int i = 0; i < len; i++) {
            char currChar = s.charAt(i);
            // case 1:
            if (currChar == '+' || currChar == '-') {
                sign = currChar == '+' ? 1 : -1;
                continue;
            }
            // case 2:
            if (currChar == '(') {
                numStack.push(res);
                signStack.push(sign);
                res = 0;
                sign = 1;
                continue;
            }
            // case 3:
            if (currChar == ')') {
                res = numStack.pop() + res * signStack.pop();
                continue;
            }
            // case 4:
            if (Character.isDigit(currChar)) {
                int temp = currChar - '0';
                char nextChar;
                while (i < len - 1 && Character.isDigit((nextChar = s.charAt(i + 1)))) {
                    temp = temp * 10 + nextChar - '0';
                    i++;
                }
                res += sign * temp;
            }

        }
        return res;

    }

    public int calculate2(String s) {
        s = s.replace(" ", "");
        int len = s.length();
        int res = 0;
        int sign = 1;
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Integer> signStack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            char currChar = s.charAt(i);
            // case 1:
            if (currChar == '+' || currChar == '-') {
                sign = currChar == '+' ? 1 : -1;
                continue;
            }
            // case 2:
            if (currChar == '(') {
                numStack.push(res);
                signStack.push(sign);
                res = 0;
                sign = 1;
                continue;
            }
            // case 3:
            if (currChar == ')') {
                res = numStack.pop() + res * signStack.pop();
                continue;
            }
            // case 4:
            if (Character.isDigit(currChar)) {
                int temp = currChar - '0';
                char nextChar;
                while (i < len - 1 && Character.isDigit(nextChar = s.charAt(i + 1))) {
                    temp = temp * 10 + nextChar - '0';
                    i++;
                }
                res += sign * temp;
            }

        }

        return res;

    }
}
