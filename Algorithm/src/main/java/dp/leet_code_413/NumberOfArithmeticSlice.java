package dp.leet_code_413;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2022/11/12 22:31
 * @Desc : 413. 等差数列划分
 * <p>
 * https://leetcode.cn/problems/arithmetic-slices/description/
 * <p>
 * 题解：https://www.youtube.com/watch?v=DEqVRwxYt6U
 */
public class NumberOfArithmeticSlice {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        int len = nums.length;
        if (len <= 2) {
            return res;
        }

        int[] dp = new int[len];
        for (int i = 2; i < len; i++) {

            int prePreValue = nums[i - 2];
            int preValue = nums[i - 1];
            int currValue = nums[i];
            if (currValue - preValue == preValue - prePreValue) {
                // dp = 1+dp;
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            }
        }
        return res;

    }
}
