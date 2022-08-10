package stack.leet_code_224;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  11/13/21 7:54 PM
 * @Desc :  基本计算器： https://leetcode-cn.com/problems/basic-calculator/submissions/
 * <p>
 * 题解：https://leetcode-cn.com/problems/basic-calculator/solution/shuang-zhan-shuang-90-by-cyingenohalt-eoy3/
 */
public class Calculate2 {
    public static void main(String[] args) {
        String s = "2147483647";
        Calculate2 calculate = new Calculate2() ;
        int result = calculate.calculate(s);
        System.err.println("result : "+result);


    }

    public int calculate(String s) {
        s = s.replace(" ", "");
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
            // case 1:
            if (curChar == '+' || curChar == '-') {
                sign = curChar == '+' ? 1 : -1;
                // 接着循环
                continue;
            }
            // case 2:
            if (Character.isDigit(curChar)) {
                // 转成 int 类型的值
                int num = curChar - '0';
                char nextChar;
                while (i < len - 1 && Character.isDigit((nextChar = strs[i + 1]))) {
                    num = num * 10 + (nextChar - '0');
                    i++;
                }
                ans += sign * num;
                continue;
            }
            // case 3:
            if (curChar == '(') {
                stNums.push(ans);
                stSigns.push(sign);
                ans = 0;
                sign = 1;
                continue;
            }
            // case 4:
            // 开始做累加操作
            if (curChar == ')') {
                //  ans * stSigns.pop(): 是加 还是减，就看这里的符号了；
                ans = stNums.pop() + ans * stSigns.pop();
            }
        }
        return ans;
    }
}
