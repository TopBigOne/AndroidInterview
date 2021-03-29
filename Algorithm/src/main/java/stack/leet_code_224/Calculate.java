package stack.leet_code_224;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/29 20:26
 * @Desc : 基本计算器(https://leetcode-cn.com/problems/basic-calculator/submissions/)
 * <p>
 * 字节半年出了 13 次
 * 题解：(https://leetcode-cn.com/problems/basic-calculator/solution/shuang-zhan-shuang-90-by-cyingenohalt-eoy3/)
 */
public class Calculate {
    private static final char SYMBOL_ADD = '+';
    public static final char SYMBOL_SUB = '-';
    public static final char C_NINE = '9';
    public static final char C_ZERO = '0';
    public static final char C_EMPTY = ' ';
    public static final char BRACKET_LEFT = '(';
    public static final char BRACKET_RIGHT = ')';

    /**
     * @param
     * @return
     */
    public int calculate(String s) {
        int ans = 0;
        char[] str = s.toCharArray();
        int len = str.length;
        Stack<Integer> stNum = new Stack<>();
        Stack<Integer> stSigns = new Stack<>();


        // 正负号，运算符号；
        int sign = 1;
        for (int i = 0; i < len; i++) {
            char curChar = str[i];
            if (curChar == C_EMPTY) {
                continue;
            }
            if (curChar == SYMBOL_ADD || curChar == SYMBOL_SUB) {
                sign = curChar == SYMBOL_ADD ? 1 : -1;
                continue;
            }
            if (curChar >= C_ZERO && curChar <= C_NINE) {
                int num = curChar - C_ZERO;
                while (i < len - 1 && str[i + 1] >= C_ZERO && str[i + 1] <= C_NINE) {
                    num = num * 10 + (str[++i] - C_ZERO);
                }
                ans += sign * num;
                continue;
            }

            // 左括号，暂存结果
            if (str[i] == BRACKET_LEFT) {

                stNum.push(ans);
                stSigns.push(sign);
                ans = 0;
                sign = 1;
                continue;
            }
            if (str[i] == BRACKET_RIGHT) {
                // 右括号更新结果
                ans = stNum.pop() + ans * stSigns.pop();
            }
        }
        return ans;
    }

    public int calcute2(String s) {
        int ans = 0;
        char[] strs = s.toCharArray();
        int len = strs.length;
        Stack<Integer> stNums = new Stack<>();
        Stack<Integer> stSigns = new Stack<>();
        // 加法：1，减法：-1；
        int sign = 1;
        for (int i = 0; i < len; i++) {
            char curChar = strs[i];
            // 如果为空，就不处理，进行下一次循环；
            if (curChar == C_EMPTY) {
                continue;
            }
            // 要么加法，要么减法
            if (curChar == SYMBOL_ADD || curChar == SYMBOL_SUB) {
                sign = curChar == SYMBOL_ADD ? 1 : -1;
                continue;
            }
            // 字符在 0-9
            if (curChar >= C_ZERO && curChar <= C_NINE) {
                // 牛 B，是一下子，，就转过来了？
                int num = curChar - C_ZERO;
                while (i < len - 1 && strs[i + 1] >= C_ZERO && strs[i + 1] <= C_NINE) {
                    num = num * 10 + (strs[++i] - C_ZERO);
                }
                ans += sign * num;
                continue;
            }
            if (curChar == BRACKET_LEFT) {
                stNums.push(ans);
                stSigns.push(sign);
                ans = 0;
                sign = 1;
                continue;
            }
            if (curChar == BRACKET_RIGHT) {
                ans = stNums.pop() + ans * stSigns.pop();
            }
        }

        return ans;

    }

}
