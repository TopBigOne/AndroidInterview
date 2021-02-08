package dp.leet_code_494;

/**
 * @author : dev
 * @version :
 * @Date :  2/3/21 2:41 PM
 * @Desc :目标和
 * <p>
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例：
 * <p>
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 * <p>
 * <p>
 * 题解：https://leetcode-cn.com/problems/target-sum/solution/python-dfs-xiang-jie-by-jimmy00745/
 */

public class FindTargetSumWay {
    /**
     * 01背包解法
     *
     * @param nums
     * @param s
     * @return
     */
    public int findTargetSumWays1(int[] nums, int s) {
        if (nums == null || nums.length == 0) return 0;
        int sums = 0;
        for (int num : nums) sums += num;
        if (sums < s || (s + sums) % 2 == 1) return 0;

        int p = (s + sums) >> 1;

        int[] dp = new int[p + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = p; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[p];
    }

    public int findTargetSumWays2(int[] nums, int s) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < s || (s + sum) % 2 == 1) {
            return 0;
        }
        int p = (s + sum) >> 1;
        int[] dp = new int[p + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = p; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[p];
    }

    public int findTargetSumWay3(int[] nums, int s) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum < s || (s + sum) % 2 == 1) return 0;
        int p = (s + sum) >> 1;
        int[] dp = new int[p + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = p; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[p];
    }


    public int findTargetSumWay4(int[] nums, int s) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (s > sum || (s + sum) % 2 == 1) return 0;

        int p = (s + sum) >> 1;
        int[] dp = new int[p + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = p; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[p];
    }


    public int findTargetSumWay6(int[] nums, int s) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (s > sum || (s + sum) % 2 == 1) return 0;
        int p = (s + sum) >> 1;
        int[] dp = new int[p + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = p; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[p];
    }

    public int findTargetSumWay5(int[] nums, int s) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (s > sum || (s + sum) % 2 == 1) return 0;
        int p = (s + sum) >> 1;
        int[] dp = new int[p + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = p; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[p];
    }

    public int findTargetSumWay7(int[] nums, int s) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        for (int num : nums) sum += num;
        if (s > sum || (s + sum) % 2 == 1) return 0;
        int p = (s + sum) >> 1;
        int[] dp = new int[p + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = p; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return  dp[p];
    }


}
