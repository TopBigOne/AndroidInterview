package stack.leet_code_1249;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/24 20:15
 * @Desc : 移除无效括号（https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses/）
 */
public class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> bracketIndex = new Stack<>();
        int length = s.length();
        boolean[] invalidIndex = new boolean[length];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char curChar = s.charAt(i);
            if (curChar == '(') {
                bracketIndex.push(i);
                invalidIndex[i] = true;
            }
            if (curChar == ')') {
                if (bracketIndex.isEmpty()) {
                    invalidIndex[i] = true;
                } else {
                    invalidIndex[bracketIndex.pop()] = false;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (!invalidIndex[i]) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public String minRemoveToMakeValid2(String s) {
        Stack<Integer> bracketIndex = new Stack<>();
        int length = s.length();
        boolean[] invalidIndex = new boolean[length];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char curChar = s.charAt(i);
            if (curChar == '(') {
                bracketIndex.push(i);
                invalidIndex[i] = true;
            }
            if (curChar == ')') {
                if (bracketIndex.isEmpty()) {
                    invalidIndex[i] = true;
                } else {
                    invalidIndex[bracketIndex.pop()] = false;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            if (!invalidIndex[i]) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();

    }

    public String minRemoveToMakeValid3(String s) {
        StringBuilder result = new StringBuilder();
        int length = s.length();
        // 有效是：false，无效是true，长度和字符串s的长度一样，就是为了一一对应每一个下标
        boolean[] invalidIndex = new boolean[length];
        Stack<Integer> bracketStack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char curChar = s.charAt(i);

            if (curChar == '(') {
                bracketStack.push(i);
                invalidIndex[i] = true;
                continue;
            }
            if (curChar == ')') {
                if (bracketStack.isEmpty()) {
                    invalidIndex[i] = true;
                } else {
                    invalidIndex[bracketStack.pop()] = false;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            if (!invalidIndex[i]) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }


    public String minRemoveToMakeValid4(String s) {
       StringBuilder result = new StringBuilder();
        int length = s.length();
        boolean[] invalidIndex = new boolean[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
                invalidIndex[i] = true;
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    invalidIndex[i] = true;
                } else {
                    invalidIndex[stack.pop()] = false;
                }

            }
        }

        for (int i = 0; i < length; i++) {
            if (!invalidIndex[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
        

    }


}
