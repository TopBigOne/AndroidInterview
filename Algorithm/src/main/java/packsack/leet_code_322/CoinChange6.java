package packsack.leet_code_322;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 20:50
 * @Desc :
 */
public class CoinChange6 {
    public int coinChange(int[] coins, int amount) {

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
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];

    }
}
