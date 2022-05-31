package dp.offer_42;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/31 17:04
 * @Desc : 连续子数组的最大和： https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 题解：https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/gong-shui-san-xie-jian-dan-xian-xing-dp-mqk5v/
 */
public class MaxSubArray2 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArray2 maxSubArray = new MaxSubArray2();
        int result = maxSubArray.maxSubArray2(nums);
        System.err.println("result : " + result);

    }

    /**
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }

            result = Math.max(result, dp[i]);

        }
        return result;

    }

    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        // 以nums[i] 自身 作为独立数组：dp[i] = nums[i];
        // nums[i] 与之前的数值 组成的子数组，由于是子数组，只能接在nums[i-1] ,
        // dp[i] = dp[i-1] + nums[i]
        // dp[i] = math.max(dp[i-1],dp[i-1] +nums[i]);
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        System.err.println("DP : " + Arrays.toString(dp));
        return res;


    }
}
