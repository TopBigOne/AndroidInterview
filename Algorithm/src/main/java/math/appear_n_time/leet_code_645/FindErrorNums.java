package math.appear_n_time.leet_code_645;

import java.util.Arrays;

import math.appear_n_time.Base;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/10 17:57
 * @Desc : 645. 错误的集合  https://leetcode.cn/problems/set-mismatch/
 * <p>
 * https://leetcode.cn/problems/set-mismatch/solution/gong-shui-san-xie-yi-ti-san-jie-ji-shu-s-vnr9/
 */
public class FindErrorNums extends Base {
    public static void main(String[] args) {
        FindErrorNums findErrorNums = new FindErrorNums();
        // []
        int[] nums = {3, 2, 3, 4, 6, 5};
        int[] result = findErrorNums.findErrorNums2(nums);
        System.err.println(Arrays.toString(result));
    }

    /**
     * 计数 解法
     *
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] window = new int[n + 1];
        for (int x : nums) {
            window[x]++;
        }
        int[] ans = new int[2];

        for (int i = 1; i <= n; i++) {
            if (window[i] == 0) {
                ans[1] = i;
                continue;
            }
            if (window[i] == 2) {
                ans[0] = i;
            }
        }
        return ans;

    }

    /**
     * 桶排序
     *
     * @param nums
     * @return
     */
    public int[] findErrorNums2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int currValue = nums[i];
            while (currValue != i + 1 && currValue != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        int a = -1, b = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                a = nums[i];
                if (i == 0) {
                    b = 1;
                } else {
                    b = nums[i - 1] + 1;
                }
            }
        }
        return new int[]{a, b};


    }

}
