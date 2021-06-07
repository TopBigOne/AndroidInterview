package dp.interview_17_16;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/7 21:56
 * @Url :https://leetcode-cn.com/problems/the-masseuse-lcci/
 * @Level : easy medium hard
 * @Desc : 按摩师
 * @Counter :
 * @Answer :
 */
public class Massage {
    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

        }

        return dp[len - 1];

    }

}
