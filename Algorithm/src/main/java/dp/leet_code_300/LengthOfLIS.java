package dp.leet_code_300;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  4/10/21 12:37 AM
 * @Desc : leet code 300 : 最长递增子序列# https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * <p>
 * 题解：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/
 */
public class LengthOfLIS {
    /**
     * 动态规划的基本解法(正确的)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;


    }

    public int lengthOfLIS2(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                // 做条件限制
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

        }

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
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;

    }

    public int lengthOfLIS4(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        System.out.println(Arrays.toString(nums));

        for (int rightIndex = 1; rightIndex < length; rightIndex++) {

            System.out.println("|---------------------------------------------------------------------|");

            for (int leftIndex = 0; leftIndex < rightIndex; leftIndex++) {
                // 右边的数，大于左边的数，才有可能做 +1 操作
                if (nums[rightIndex] > nums[leftIndex]) {
                    dp[rightIndex] = Math.max(dp[rightIndex], dp[leftIndex] + 1);
                }
                System.out.println("第" + leftIndex + "次: " + "nums[" + rightIndex + "]:" + nums[rightIndex] + ", nums[" + leftIndex + "]:" + nums[leftIndex] + ",  当前 dp 状态：" + Arrays.toString(dp));
            }
        }

        // 遍历 dp数组，取最大值
        int res = 0;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int lengthOfLIS5(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 遍历数组，求最大值
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res+1;
    }


}
