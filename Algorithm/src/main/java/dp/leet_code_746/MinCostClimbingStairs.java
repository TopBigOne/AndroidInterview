package dp.leet_code_746;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/19 23:06
 * @Desc : 题解：https://leetcode.cn/problems/min-cost-climbing-stairs/solution/yi-bu-yi-bu-tui-dao-dong-tai-gui-hua-de-duo-chong-/
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        MinCostClimbingStairs minCostClimbingStair = new MinCostClimbingStairs();
        int result = minCostClimbingStair.minCostClimbingStairs1(cost);
        System.err.println("result : " + result);
    }

    public int minCostClimbingStairs1(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < len; i++) {
            int costOne = dp[i - 1] + cost[i];
            int costTwo = dp[i - 2] + cost[i-1];
            dp[i] = Math.min(costOne,costTwo);
        }
        System.err.println(Arrays.toString(dp));
        return dp[len-1];
    }


    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        for (int i = 2; i < len; i++) {
            cost[i] = Math.min(cost[i - 2], cost[i - 1]) + cost[i];
        }
        System.err.println(Arrays.toString(cost));
        return Math.min(cost[len - 2], cost[len - 1]);
    }
}
