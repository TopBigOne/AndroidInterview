package dp.sub_sequence.leet_code_53;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/22 00:08
 * @Desc :
 * <p>
 * https://leetcode.cn/problems/maximum-subarray/
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class MaximumSubArray4 {
    public static void main(String[] args) {
        MaximumSubArray4 maximumSubArray = new MaximumSubArray4();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maximumSubArray.maxSubArray(nums);
        System.err.println("result : " + result);

    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            // 上一个，推导出下一个；
            if (dp[i - 1] > 0) {
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }
            res = Math.max(dp[i], res);
        }
        System.out.println("dp : " + Arrays.toString(dp));

        return res;

    }
}
