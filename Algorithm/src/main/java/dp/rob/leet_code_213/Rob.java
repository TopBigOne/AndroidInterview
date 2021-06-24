package dp.rob.leet_code_213;

/**
 * @author : dev
 * @version :
 * @Date :  6/24/21 10:33 PM
 * @Desc : leetcode 213 打家劫舍 字节 10 次：https://leetcode-cn.com/problems/house-robber-ii/
 * <p>
 * 数组的开头和结尾是相邻的情况下，也就是说：数组的开头和结尾元素不能同时选。
 * 这里用到一个技巧：
 * 分两种情况去考虑，分别在 nums[0 : N-1] 和 nums[1 : N] 上极端能获取到的最大值；
 * 主要需要你学会物理隔离
 */
public class Rob {
    public int rob(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob1(nums, 0, len - 1), rob1(nums, 1, len));
    }

    private int rob1(int[] nums, int start, int end) {
        int len = end - start;
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[start + i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }

    private int rob2(int[] nums, int start, int end) {
        int len = end - start;
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[start + i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }

    /**
     * @param nusm
     * @param start start 你可以理解成偏移量
     * @param end
     * @return
     */
    private int rob3(int[] nusm, int start, int end) {
        int len = end - start;
        int[] dp = new int[len];
        dp[0] = nusm[start];
        dp[1] = Math.max(nusm[start], nusm[start + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nusm[start + i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }
}
