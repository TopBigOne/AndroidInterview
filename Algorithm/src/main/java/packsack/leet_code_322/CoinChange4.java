package packsack.leet_code_322;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/25 06:30
 * @Desc :https://leetcode.cn/problems/coin-change/solution/
 */
public class CoinChange4 {
    public int coinChange(int[] coins, int amount) {
        // 凑齐总价值 i 需要的最少硬币个数；
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // check the final value
        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }
        return dp[amount];
    }
}
