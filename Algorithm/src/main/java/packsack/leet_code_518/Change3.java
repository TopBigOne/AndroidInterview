package packsack.leet_code_518;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/25 06:49
 * @Desc :
 */
public class Change3 {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int currCoin = coins[i - 1];

            for (int j = 0; j <= amount; j++) {
                // case1:dp[i - 1][j]: 不使用 i - 1处硬币的方案
                dp[i][j] = dp[i - 1][j];


                for (int time = 1; time * currCoin <= j; time++) {
                    // case 2:使用该硬币
                    dp[i][j] += dp[i - 1][j - time * currCoin];
                }
            }
        }
        return dp[len][amount];
    }

    public int change2(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        dp[0][0] = 1;   // 使用0种货币，凑0元钱,也是一种方案
        for (int i = 1; i <= len; i++) {
            int v = coins[i - 1];

            for (int j = 0; j <= amount; j++){
                for (int k = 0; k * v <= j; k++){
                    dp[i][j] += dp[i - 1][j - k * v];  //状态计算方程
                }
            }

        }
        return dp[len][amount];


    }
}
