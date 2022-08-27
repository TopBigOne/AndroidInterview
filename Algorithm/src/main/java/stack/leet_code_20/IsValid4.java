package stack.leet_code_20;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/6 21:52
 * @Desc :
 */
public class IsValid4 {
    public static void main(String[] args) {
        String s = "()[]{}";
        IsValid4 isValid = new IsValid4();
        boolean valid = isValid.isValid(s);
        System.err.println("valid : " + valid);

    }

    public boolean isValid(String s) {

        char oneLeft = '(', oneRight = ')';
        char twoLeft = '{', twoRight = '}';
        char threeLeft = '[', threeRight = ']';
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == oneLeft ||
                    c == twoLeft ||
                    c == threeLeft) {
                stack.push(c);
                continue;
            }


            if (!stack.isEmpty() && c == oneRight && stack.peek() == oneLeft) {
                stack.pop();
                continue;
            }
            if (!stack.isEmpty() && c == twoRight && stack.peek() == twoLeft) {
                stack.pop();
                continue;
            }

            if (!stack.isEmpty() && c == threeRight && stack.peek() == threeLeft) {
                stack.pop();
                continue;
            }

            return false;

        }

        return stack.isEmpty();

    }
}
