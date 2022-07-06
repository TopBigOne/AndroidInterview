package dp.sub_sequence.leet_code_300;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/6 19:56
 * @Desc :  300. 最长递增子序列
 */
public class LengthOfLIS8 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LengthOfLIS8 lengthOfLIS = new LengthOfLIS8();
        int result = lengthOfLIS.lengthOfLIS(nums);
        System.err.println("result : " + result);
    }

    /**
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }
        int res = 1;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        System.err.println("dp : " + Arrays.toString(dp));
        return res;

    }

    public int lengthOfLIS2(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 在[i,j] 范围内，寻找dp[i] 的最大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);

            }

        }
        return res;

    }

}
