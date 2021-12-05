package single_invoke_stack.offer_38;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/5 13:55
 * @Url : https://leetcode-cn.com/problems/iIQa4I/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class DailyTemperature {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperature dailyTemperature = new DailyTemperature();
        int[] result = dailyTemperature.dailyTemperatures(temperatures);
        System.out.println("result : "+Arrays.toString(result));

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int [] result = new int[length];
        // 单调栈，寻找右边第一个大于此元素的值
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            // 当栈非空，并且栈顶元素小于当前元素，
            // 则说明，该元素是右边第一个大于栈顶元素的数据
            while (!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                int index = stack.pop();
                // 将两者下标的差值存储到结果中，其余不存储的默认 为0 ，即找不到大于该元素的值；
                result[index] =i-index;
            }
            stack.push(i);
        }
        return  result;
    }
}
