package dp.leet_code_227;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/12 23:47
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Calculate {
    // 使用 map 维护一个运算符优先级
    // 这里的优先级划分按照「数学」进行划分即可
    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};

    public int calculate(String s) {
        // 将所有的空格去掉
        s = s.replaceAll(" ", "");
        char[] cs = s.toCharArray();
        int n = s.length();
        // 存放所有的数字
        Deque<Integer> nums = new ArrayDeque<>();
        // 为了防止第一个数为负数，先往 nums 加个 0
        nums.addLast(0);
        // 存放所有「非数字以外」的操作
        Deque<Character> ops = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
                continue;
            }
            if (c == ')') {
                // 计算到最近一个左括号为止
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
                continue;
            }
            // 是数字
            if (isNumber(c)) {
                int u = 0;
                int j = i;
                // 将从 i 位置开始后面的连续数字整体取出，加入 nums
                while (j < n && isNumber(cs[j])) u = u * 10 + (cs[j++] - '0');
                nums.addLast(u);
                i = j - 1;
                continue;
            }
            // 不是数字
            if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                nums.addLast(0);
            }
            // 有一个新操作要入栈时，先把栈内可以算的都算了
            // 只有满足「栈内运算符」比「当前运算符」优先级高/同等，才进行运算
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
        // 将剩余的计算完
        while (!ops.isEmpty()) calc(nums, ops);
        return nums.peekLast();
    }

    public void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollLast();
        int a = nums.pollLast();
        char op = ops.pollLast();
        int ans = 0;
        if (op == '+') ans = a + b;
        else if (op == '-') ans = a - b;
        else if (op == '*') ans = a * b;
        else if (op == '/') ans = a / b;
        else if (op == '^') ans = (int) Math.pow(a, b);
        else if (op == '%') ans = a % b;
        nums.addLast(ans);
    }

    public boolean isNumber(char c) {
        return Character.isDigit(c);
    }

}
