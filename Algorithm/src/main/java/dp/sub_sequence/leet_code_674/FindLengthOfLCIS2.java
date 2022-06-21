package dp.sub_sequence.leet_code_674;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/20 22:42
 * @Desc : 使用动态规划的思想
 */
public class FindLengthOfLCIS2 {
    public static void main(String[] args) {
        FindLengthOfLCIS2 findLengthOfLCIS = new FindLengthOfLCIS2();
        // []
        int[] nums = {1, 3, 5, 4, 2, 3, 4, 5};
        int result = findLengthOfLCIS.findLengthOfLCIS2(nums);
        System.err.println("result : " + result);

    }

    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }

            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int findLengthOfLCIS2(int[] nums) {
        int res = 1;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        dp[0] = 1;


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        System.err.println(" dp :" + Arrays.toString(dp));
        return res;

    }


}
