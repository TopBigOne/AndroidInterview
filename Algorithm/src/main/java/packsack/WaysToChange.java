package packsack;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/18 11:08
 * @Desc :面试题 08.11. 硬币
 * https://leetcode.cn/problems/coin-lcci/
 * https://leetcode.cn/problems/coin-lcci/solution/java-wan-quan-bei-bao-xiang-xi-ti-jie-yu-yi-bu-bu-/
 */
public class WaysToChange {
    /**
     * 方法1：没有对状态进行压缩
     *
     * @param n
     * @return
     */
    public int waysToChange(int n) {
        int[][] dp = new int[5][n + 1];
        int[] coins = {1, 5, 10, 25};
        for (int i = 1; i <= 4; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= 4; i++) {

            for (int j = 1; j <= n; j++) {
                if (j - coins[i - 1] < 0) {
                    // 不做选择
                    dp[i][j] = dp[i - 1][j];
                } else {

                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
                // 取模运算
                dp[i - 1][j] %= 1000000007;
            }
        }

        return dp[4][n];

    }

    public int waysToChange2(int n) {
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= n; i++) {
                if (i - coin >= 0) {
                    dp[i] = dp[i] + dp[i - coin];
                    dp[i] %= 1000000007;
                }
            }
        }
        return dp[n];


    }
}
