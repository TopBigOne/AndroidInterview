package dp.rob.leet_code_198;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/4 22:37
 * @Desc :
 */
public class Rob2 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

        }
        return dp[length - 1];


    }
}
