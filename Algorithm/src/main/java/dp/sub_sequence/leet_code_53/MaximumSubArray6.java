package dp.sub_sequence.leet_code_53;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/12 19:44
 * @Desc : 53. 最大子数组和: https://leetcode.cn/problems/maximum-subarray/
 */
public class MaximumSubArray6 {
    public int maxSubArray(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
