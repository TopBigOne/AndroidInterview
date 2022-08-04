package dp.rob.leet_code_213;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/4 23:50
 * @Desc : leetcode 213 打家劫舍 字节 10 次：https://leetcode-cn.com/problems/house-robber-ii/
 * 题解：https://www.youtube.com/watch?v=hm3PPds59-0
 */
public class Rob2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        Rob2 rob = new Rob2();
        int result = rob.rob(nums);
        System.err.println("result : " + result);
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(help(nums, 0, len - 2), help(nums, 1, len - 1));

    }

    private int help(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        }
        int len = end - start + 1;
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[i + start] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }


    private int help2(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        }

        int len = end - start + 1;

        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[i + start] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];

    }

}
