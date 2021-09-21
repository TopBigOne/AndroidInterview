package string.leet_code_1190;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/11 23:45
 * @Url : https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * @Level :  easy  medium hard
 * @Desc :  反转每对括号间的子串
 * @Counter : 2
 * @Answer : https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/solution/fan-zhuan-mei-dui-gua-hao-jian-de-zi-chu-gwpv/
 */
public class ReverseParentheses {
    /**
     * 栈解法
     *
     * @param s
     * @return
     */
    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
                continue;
            }
            if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.poll());
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * 预处理括号
     *
     * @param s
     * @return
     */
    public String reverseParentheses2(String s) {
        int length = s.length();
        int[] pair = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
                continue;
            }
            if (ch == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;

            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int step = 1;
        while (index < length) {
            char ch = s.charAt(index);
            if (ch == '(' || ch == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(ch);
            }
            index += step;
        }
        return sb.toString();

    }

    public String reverseParentheses3(String s) {
        int length = s.length();
        int[] pair = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
                continue;

            }
            if (ch == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;

            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int step = 1;
        while (index < length) {
            char ch = s.charAt(index);
            if (ch == '(' || ch == ')') {
                index = pair[index];
                step -= step;
            } else {
                sb.append(ch);
            }
            index += step;
        }

        return sb.toString();
    }

    public String reverseParentheses4(String s) {
        int length = s.length();
        int[] pair = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
                continue;
            }
            if (ch == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int step = 1;
        while (index < length) {
            char ch = s.charAt(index);
            if (ch == '(' || ch == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(ch);
            }
            index += step;
        }
        return sb.toString();


    }

    public String reverseParentheses5(String s) {
        int length = s.length();
        int[] pair = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
                continue;
            }
            if (ch == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }

        }


        StringBuilder sb = new StringBuilder();
        int index = 0;
        int step = 1;
        while (index < length) {
            char ch = s.charAt(index);
            if (ch == '(' || ch == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(ch);
            }
            index += step;
        }

        return sb.toString();
    }
}
