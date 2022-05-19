package n_sum.leet_code_167;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/17 18:52
 * @Desc :
 */
public class TwoSum2 {
    public static void main(String[] args) {
        TwoSum2 twoSum2 = new TwoSum2();
        int[] nums = {2, 3, 4};
        int target = 6;
        int[] result = twoSum2.twoSum(nums, target);
        System.out.println("result :" + Arrays.toString(result));

    }

    /**
     * @param numbers 有序数组
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            int right = binary(numbers, i + 1, target - numbers[i]);
            if (right != -1) {
                return new int[]{i + 1, right + 1};
            }

        }
        return new int[0];

    }

    private int binary(int[] numbers, int start, int target) {
        int end = numbers.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                start++;
            } else {
                end--;
            }
        }

        return -1;
    }


}
