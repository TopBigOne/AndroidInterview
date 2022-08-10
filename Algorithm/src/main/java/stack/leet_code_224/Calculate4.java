package stack.leet_code_224;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/10 17:08
 * @Desc :
 */
public class Calculate4 {

    public int calculate(String s) {
        s = s.replace(" ", "");
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Integer> signStack = new ArrayDeque<>();
        int res = 0;
        int sign = 1;
        int len = s.length();
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
