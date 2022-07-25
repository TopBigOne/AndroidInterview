package packsack.leet_code_322;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/25 02:00
 * @Desc :
 * https://leetcode.cn/problems/coin-change/solution/
 */
public class CoinChange3 {
    /**
     *
     * @param coins
     * @param amount
     * @return   计算并返回可以凑成总金额所需的 最少的硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 从coins[0]遍历到coins[len-1],
            // 找到dp[i] 的最小值
            for (int coin : coins) {
                // 硬币的面额大约 当前所需的面额，不符合题意；
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }
        return dp[amount];

    }
}
