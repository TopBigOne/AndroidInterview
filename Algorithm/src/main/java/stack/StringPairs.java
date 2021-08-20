package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/8/11 16:26
 * @Url :
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :
 * <p>
 * 给定一个字符串。里面可能包含“（）”，“[]”，“{}”三种括号，
 * 请编写程序检查该字符串的括号是否成对出现。
 * 输出：true：    代表括号成对出现并且嵌套正确，或者字符串没括号
 * False:     未正确使用括号字符
 */

public class StringPairs {
    public static void main(String[] args) {
        StringPairs stringPairs = new StringPairs();
        String strs = "()[]";
        boolean result = stringPairs.isPairs(strs);
        System.out.println("result : " + result);
    }

    /**
     * @param str （）[]
     * @return result;
     */
    public boolean isPairs(String str) {
        // base corner
        if (str == null || str.length() == 0) {
            return false;
        }
        char typeOneLeft = '(';
        char typeTwoLeft = '[';

        char typeOneRight = ')';
        char typeTwoRight = ']';

        char[] chars = str.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char currChar : chars) {
            stack.push(currChar);
        }
        while (!stack.isEmpty()) {
            Character currChar = stack.poll();
            Character peekValue;
            // 1-1： 栈顶弹出的是小左括号，那就判断当前的栈顶是否为：小右括号？
            // 等于的话，就直接pop出来，进行下一轮循环
            if (currChar == typeOneLeft) {
                if ((peekValue = stack.peek()) != null && peekValue == typeOneRight) {
                    stack.poll();
                    continue;
                }
                return false;
            }
            // 1-2
            if (currChar == typeOneRight) {
                if ((peekValue = stack.peek()) != null && peekValue == typeOneLeft) {
                    stack.poll();
                    continue;
                }
                return false;
            }
            // 2-1：做中括号判断
            if (currChar == typeTwoLeft) {
                if ((peekValue = stack.peek()) != null && peekValue == typeTwoRight) {
                    stack.poll();
                    continue;
                }
                return false;
            }
            // 2-2
            if (currChar == typeTwoRight) {
                if ((peekValue = stack.peek()) != null && peekValue == typeTwoLeft) {
                    stack.poll();
                    continue;
                }
                return false;
            }
        }
        // 3: stack 的数据全部弹出，没有发现不相等的字符
        return true;
    }
}
