package n_sum.leet_code_167;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  6/19/21 6:53 PM
 * @Desc : leetcode  167 两数之和，输入有序数组  ：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 题解：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/shuang-zhi-zhen-dui-zhuang-er-fen-fa-python-dai-ma/
 */
public class TwoSum {
    /**
     * 还是使用了，hash 思想
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int length;
        int[] result = new int[2];
        if (numbers == null || (length = numbers.length) == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int temp = target - numbers[i];
            if (map.containsKey(temp)) {
                result[0] = map.get(temp) + 1;
                result[1] = i + 1;
                break;
            }
            map.put(numbers[i], i);
        }
        return result;
    }


    /**
     * 使用双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int left = 0;
        // 一定要减 1啊....
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum < target) {
                left++;
                continue;
            }
            if (sum > target) {
                right--;
                continue;
            }
        }
        return null;
    }

    /**
     * 使用二分法： 二分查找，起点固定，外面要套上一层循环
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        int len = nums.length;
        // 最后一个数字，不会作为起始数字，
        for (int left = 0; left < len - 1; left++) {
            // 挨个二分查找
            int right = binarySearch(nums, left + 1, len - 1, target - nums[left]);
            if (right != -1) {
                return new int[]{left + 1, right + 1};
            }
        }
        return null;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (right + left) >>> 1;
            int curr = nums[mid];
            if (curr == target) {
                return mid;
            }
            if (curr < target) {
                left++;
                continue;
            }
            if (curr > 1) {
                right--;
                continue;
            }
        }
        return -1;
    }

}
