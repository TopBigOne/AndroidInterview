package stack.leet_code_227;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/5 14:42
 * @Desc :
 */
public class Calculate4 {
    public int calculate(String s) {


        s = s.replace(" ", "");
        int len;
        if ((len = s.length()) == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int currNum = 0;
        char sign = '+';


        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                currNum = s.charAt(i) - '0';
                // 如果当前数字的后边也是数字，那就要*10来得到这整个的数字
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    currNum = currNum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            }
            // 得到一个运算符
            // 不是数字也不是空格
            // 注意最后一个数字，由于符号总是在数字之前，
            // 因此最后一个数字无法计算，这时需要使用i == len - 1进行最后一次运算
            if (!Character.isDigit(s.charAt(i)) || i == len - 1) {
                // 如果是+-就放进去
                if (sign == '+') stack.push(currNum);
                if (sign == '-') stack.push(-currNum);
                // 如果是*/就先计算再放进去
                if (sign == '*') stack.push(stack.pop() * currNum);
                if (sign == '/') stack.push(stack.pop() / currNum);
                sign = s.charAt(i);
                currNum = 0;
            }
        }
        for (int i : stack) {
            res += i;
        }
        return res;

    }
}
