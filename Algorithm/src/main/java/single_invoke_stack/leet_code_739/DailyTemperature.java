package single_invoke_stack.leet_code_739;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/5 16:59
 * @Url :leetcode 739 : 每日温度 https://leetcode-cn.com/problems/daily-temperatures/submissions/
 * @Level :    medium
 * @Desc : 每日温度
 * @Counter : 7
 * @Answer :
 */
public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();

                result[index] = i - index;
            }


            stack.push(i);
        }
        return result;

    }

    public int[] dailyTemperatures3(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;

    }

    public int[] dailyTemperatures4(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int popIndex = stack.pop();
                result[popIndex] = i - popIndex;
            }
            stack.push(i);
        }
        return result;
    }

    public int[] dailyTemperatures5(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int popIdx = stack.pop();
                result[popIdx] = i - popIdx;
            }
            stack.push(i);
        }
        return result;
    }


}
