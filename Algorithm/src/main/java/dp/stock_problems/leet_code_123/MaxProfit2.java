package dp.stock_problems.leet_code_123;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/12 19:55
 * @Desc :
 */
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][][] dp = new int[len][3][2];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            int currPrice = prices[i];
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -currPrice);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1]+currPrice);

            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - currPrice);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + currPrice);

        }

        return Math.max(dp[len - 1][1][0], dp[len - 1][2][0]);


    }
}
