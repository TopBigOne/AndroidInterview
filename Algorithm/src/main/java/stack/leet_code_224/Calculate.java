package stack.leet_code_224;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/29 20:26
 * @Desc : 基本计算器(https://leetcode-cn.com/problems/basic-calculator/submissions/)
 * <p>
 * 题解：(https://leetcode-cn.com/problems/basic-calculator/solution/shuang-zhan-shuang-90-by-cyingenohalt-eoy3/)
 */
public class Calculate {
    /**
     * @param
     * @returnÂ
     */
    public int calculated(String s) {
        int ans = 0;
        char[] str = s.toCharArray();
        int len = str.length;
        Stack<Integer> stNum = new Stack<>();
        Stack<Integer> stSigns = new Stack<>();
        // 正负号，运算符号；
        int sign = 1;
        for (int i = 0; i < len; i++) {
            char curChar = str[i];
            if (curChar == ' ') {
                continue;
            }
            if (curChar == '+' || curChar == '-') {
                sign = curChar == '+' ? 1 : -1;
            } else if (curChar >= '0' && curChar <= '9') {
                int num = curChar - '0';
                while (i < len - 1 && str[i + 1] >= '0' && str[i + 1] <= '9') {
                    num = num * 10 + (str[++i] - '0');
                }
                ans += sign * num;
            } else if (str[i] == '(') {
                // 左括号，暂存结果
                stNum.push(ans);
                stSigns.push(sign);
                ans = 0;
                sign = 1;
            } else {
                // 右括号更新结果
                ans = stNum.pop() + ans * stSigns.pop();
            }

        }
        return ans;


    }

}
