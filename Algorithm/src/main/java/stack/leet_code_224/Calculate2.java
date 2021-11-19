package stack.leet_code_224;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  11/13/21 7:54 PM
 * @Desc :  基本计算器： https://leetcode-cn.com/problems/basic-calculator/submissions/
 *
 * 题解：https://leetcode-cn.com/problems/basic-calculator/solution/shuang-zhan-shuang-90-by-cyingenohalt-eoy3/
 */
public class Calculate2 {
    char SYMBOL_ADD = '+';
    char SYMBOL_SUB = '-';
    char C_NINE = '9';
    char C_ZERO = '0';
    char C_EMPTY = ' ';
    char BRACKRT_LEFT = '(';
    char BRACKET_RIGHT = ')';

    public int calculate(String s) {
        int ans = 0;
        char[] strs = s.toCharArray();
        int len = strs.length;
        Stack<Integer> stNums = new Stack<>();
        Stack<Integer> stSigns = new Stack<>();
        // 加法：1；
        // 减法：-1；
        int sign = 1;
        for (int i = 0; i < len; i++) {
            char curChar = strs[i];
            // if the current char is null, continue the loop;
            if (curChar == C_EMPTY) {
                continue;
            }
            if (curChar == SYMBOL_ADD || curChar == SYMBOL_SUB) {
                sign = curChar == SYMBOL_ADD ? 1 : -1;
                // 接着循环
                continue;
            }
            // 字符在 0-9；
            if (curChar >= C_ZERO && curChar <= C_NINE) {
                // 转成 int 类型的值
                int num = curChar - C_ZERO;
                while (i < len - 1 && strs[i + 1] >= C_ZERO && strs[i + 1] <= C_NINE) {
                    num = num * 10 + (strs[++i] - C_ZERO);
                }
                ans += sign * num;
                continue;
            }

            // 左括号
            if (curChar == BRACKRT_LEFT) {
                stNums.push(ans);
                stSigns.push(sign);
                ans = 0;
                sign = 1;
                continue;
            }
            // 右括号
            if (curChar == BRACKET_RIGHT) {
                ans = stNums.pop() + ans * stSigns.pop();
            }
        }

        return ans;
    }
}
