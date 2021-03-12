package stack.leet_code_739;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : dev
 * @version :
 * @Date :  3/11/21 11:43 AM
 * @Desc :  每日温度：(https://leetcode-cn.com/problems/daily-temperatures/)
 * 题解：https://leetcode-cn.com/problems/daily-temperatures/solution/javadan-diao-zhan-ni-xu-bian-li-by-hyh-2/
 * <p>
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */

public class DailyTemperature {
    public int[] dailyTemperatureArray(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        // 单调栈 里面的数 非递增排序 
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            // 当前元素比栈顶元素大 出栈 重新调整栈直至满足要求
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                // 栈为空 即后面没有比当前天温度高的
                res[i] = 0;
            } else {
                // 不为空 栈顶元素对应的下标减去当前下标即为经过几天后温度比当前天温度高
                res[i] = stack.peek() - i;
            }
            // 当前元素进栈
            stack.push(i);
        }
        return res;
    }

    public int[] dailyTemperature2(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;

            } else {
                result[i] = stack.peek() - i;
            }
            stack.push(i);

        }
        return result;
    }

    public int[] dailyTemperature3(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        Deque<Integer> stack = new ArrayDeque<>(16);
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();

            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }

    public int[] dailyTemperature4(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        Deque<Integer> stack = new ArrayDeque<>(16);
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);

        }
        return result;
    }


}
