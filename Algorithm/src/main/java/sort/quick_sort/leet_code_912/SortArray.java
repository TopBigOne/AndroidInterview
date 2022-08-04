package sort.quick_sort.leet_code_912;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2/18/21 12:04 AM
 * @Desc : 912 : 排序数组（https://leetcode-cn.com/problems/sort-an-array/）
 */
public class SortArray {
    /**
     * 执行用时：
     *  4 ms
     * , 在所有 Java 提交中击败了 98.93%
     *
     * 的用户
     * 内存消耗： 46.1 MB
     *
    * 在所有 Java 提交中击败了16.27%
     *
     * 的用户
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 99.97%
     * 的用户
     * 内存消耗：
     * 45.7 MB
     * , 在所有 Java 提交中击败了
     * 80.46%
     * 的用户
     * @param nums
     * @return
     */
    public int[] sortArray2(int[] nums) {
        int max = -50001, min = 50001;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }


        int[] counter = new int[max - min + 1];
        for (int num : nums) {
            counter[num - min]++;
        }

        int idx = 0;
        for (int num = min; num <= max; num++) {
            int cnt = counter[num - min];
            while (cnt-- > 0) {
                nums[idx++] = num;
            }
        }
        return nums;
    }

}
