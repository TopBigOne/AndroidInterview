package array.sub_array.leet_code_907;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/14 20:09
 * @Desc :
 */
public class SumSubArrayMin4 {
    public static void main(String[] args) {
        SumSubArrayMin4 min = new SumSubArrayMin4();
        int[] arr = {3, 1, 2, 4};
        int result = min.sumSubarrayMins(arr);
        System.err.println("result : " + result);
    }

    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int len;
        // 处理边界情况
        if (arr == null || (len = arr.length) == 0) {
            return 0;
        }
        long ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        // 将下标-1和n作为两个哨兵元素，它们对应的元素为MIN_VALUE
        // -1作为最左边界，n作为最右边界
        for (int index = -1; index <= len; index++) {
            // 向左寻找第一个小于等于A[index]的元素
            while (!stack.isEmpty() && index > 0 && index != arr.length && arr[stack.peek()] > arr[index]) {
                // while (!stack.isEmpty() && getElement(arr, stack.peek()) > getElement(arr, index)) {
                // A[popIndex]就是之前思路中的A[index]，注意区分和上面代码的区别
                // 对于每个出栈元素来说，i就是它们的右边界，而栈顶元素就是左边界
                int popIndex = stack.pop();
                // 计算贡献值
                ans = (ans + (long) (popIndex - stack.peek()) * (index - popIndex) * arr[popIndex]) % MOD;
            }
            stack.push(index);
        }
        return (int) ans;
    }

    /**
     * 重写根据下标取值方法，-1和n返回MIN_VALUE
     *
     * @param arr
     * @param index
     * @return the really  value;
     */
    private int getElement(int[] arr, int index) {
        if (index == -1 || index == arr.length) {
            return Integer.MIN_VALUE;
        }
        return arr[index];
    }

}
