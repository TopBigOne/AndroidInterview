package dp.offer_42;

/**
 * @author : dev
 * @version :
 * @Date :  6/23/21 10:40 PM
 * @Desc : offer 42 连续子数组的最大和  字节 14 次 ：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i] + sum, nums[i]);
            if (result > sum) {
                sum = result;
            }
        }
        return result;
    }

    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);

        }
        return res;


    }
}
