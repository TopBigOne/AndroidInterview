package packsack.leet_code_518;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 12:38
 * @Desc :leet code 518 零钱兑换： https://leetcode-cn.com/problems/coin-change-2/solution/
 */
public class Change5 {
    int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i < coin) {
                    continue;
                }
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }
}
