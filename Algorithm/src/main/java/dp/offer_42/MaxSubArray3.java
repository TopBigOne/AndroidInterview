package dp.offer_42;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/12 18:49
 * @Desc : 剑指 Offer 42. 连续子数组的最大和： https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray3 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
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
