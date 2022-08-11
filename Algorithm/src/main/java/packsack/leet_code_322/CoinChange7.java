package packsack.leet_code_322;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 12:24
 * @Desc :  leetcode 322： 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * --------https://leetcode-cn.com/problems/coin-change/solution/322-by-ikaruga/
 * -----: 题解：https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
 * <p>
 * 贪心 + dfs
 */
public class CoinChange7 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin]+1);
            }

        }
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];

    }
}
