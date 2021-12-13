package dp.leet_code_300;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/7 23:34
 * @Url : 最长递增子序列
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class LengthOfLIS3 {
    public static void main(String[] args) {
        int[] nums = {0, 3, 1, 6, 2, 2, 7};
        LengthOfLIS3 length = new LengthOfLIS3();
        int result = length.lengthOfLIS2(nums);
        System.out.println("result : " + result);
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int right = 0; right < length; right++) {
            for (int left = 0; left < right; left++) {
                // 右边的数，大于左边的数，才有可能+1 操作
                if (nums[right] > nums[left]) {
                    dp[right] = Math.max(dp[right], dp[left] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int right = 0; right < length; right++) {
            for (int left = 0; left < right; left++) {
                if (nums[right] > nums[left]) {
                    dp[right] = Math.max(dp[right], dp[left] + 1);
                }
            }
        }

        System.out.println("dp :" + Arrays.toString(dp));
        int res = 0;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;

    }

    public int lengthOfLIS3(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int right = 0; right < len; right++) {
            int currValue = nums[right];
            for (int left = 0; left < right; left++) {
                if (currValue > nums[left]) {
                    dp[right] = Math.max(dp[right], dp[left] + 1);
                }
            }
        }
        System.out.println("dp : " + Arrays.toString(dp));
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
