package dp.sub_sequence.leet_code_53;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/6 14:55
 * @Desc :
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class MaximumSubArray5 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubArray5 maximumSubArray = new MaximumSubArray5();
        int result = maximumSubArray.maxSubArray(nums);
        System.err.println("result : " + result);

    }

    /**
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大为 6 。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            res = Math.max(res,dp[i]);
        }

        System.err.println("dp:" + Arrays.toString(dp));
        return res;
    }
}
