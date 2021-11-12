package stack.leet_code_227;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  5/5/21 10:29 PM
 * @Desc : leet_code_227  基本计算器 : 字节 4 次：
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 * <p>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * 题解：https://leetcode-cn.com/problems/basic-calculator-ii/solution/shi-yong-shuang-zhan-jie-jue-jiu-ji-biao-c65k/
 */
public class Calculate {
    Map<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('-', 1);
            put('+', 1);
            put('*', 2);
            put('/', 2);
            put('%', 2);
            put('^', 3);
        }
    };

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        char[] cs = s.toCharArray();
        int n = s.length();
        // 存放所有的数字
        Deque<Integer> nums = new ArrayDeque<>();
        // 为了防止第一个数为负数，先往 nums 加个 0；
        nums.addLast(0);
        // 存放所有[非数字以外]的操作
        Deque<Character> ops = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
                continue;
            }
            if (c == ')') {
                // 计算得到最近一个左括号为止
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }

                }
            }
            if (isNumber(c)) {
                int u = 0;
                int j = i;
                //  将从 i 位置开始后面的连续数字整体取出，加入 nums
                while (j < n && isNumber(cs[j])) {
                    u = u * 10 + (cs[j++] - '0');
                }
                nums.addLast(u);
                i = j - 1;
            } else {
                if (i > 0 && cs[i - 1] == '(' || (cs[i - 1] == '+' ||
                        cs[i - 1] == '-')) {
                    nums.addLast(0);
                }
                while (!ops.isEmpty() && ops.peekLast() != '(') {
                    char prev = ops.peekLast();
                    if (map.get(prev) >= map.get(c)) {
                        calc(nums, ops);
                    } else {
                        break;
                    }
                }
                ops.addLast(c);
            }

        }
        while (!ops.isEmpty()) {
            calc(nums, ops);
        }
        return nums.peekLast();
    }

    public void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) {
            return;
        }
        if (ops.isEmpty()) {
            return;
        }
        int b = nums.pollLast();
        int a = nums.pollLast();
        char op = ops.pollLast();
        int ans = 0;
        if (op == '+') {
            ans = a + b;
        } else if (op == '-') {
            ans = a - b;
        } else if (op == '*') {
            ans = a * b;
        } else if (op == '^') {
            ans = (int) Math.pow(a, b);
        } else if (op == '%') {
            ans = a % b;
        }
        nums.addLast(ans);

    }

    private boolean isNumber(char c) {
        return Character.isDigit(c);
    }

}
