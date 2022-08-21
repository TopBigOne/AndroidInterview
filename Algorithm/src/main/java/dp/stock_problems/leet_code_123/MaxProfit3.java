package dp.stock_problems.leet_code_123;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/21 13:21
 * @Desc :
 */
public class MaxProfit3 {
    public int maxProfit(int[] prices) {
        int len;
        if (prices == null || (len = prices.length) == 0) {
            return 0;
        }
        // i : 天
        // j : 1: 第一笔交易；2： 第二笔交易
        // k : 0 ： 不持有股票，1： 持有股票

        int[][][] dp = new int[len][3][2];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);

            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);

        }
        return Math.max(dp[len - 1][1][0], dp[len - 1][2][0]);

    }

    public int maxProfit2(int[] prices) {
        int len;
        if (prices == null || (len = prices.length) == 0) {
            return 0;
        }
        // i : 天
        // j : 1: 第一笔交易；2： 第二笔交易
        // k : 0 ： 不持有股票，1： 持有股票
        int[][][] dp = new int[len][3][2];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);

            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i][2][1] + prices[i]);
        }

        return Math.max(dp[len - 1][1][0], dp[len - 1][2][0]);
    }

    public int maxProfit3(int[] prices) {
        int len;
        if (prices == null || (len = prices.length) == 0) {
            return 0;
        }
        int[][][] dp = new int[len][3][2];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);

            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
        }
        return Math.max(dp[len - 1][1][0], dp[len - 1][2][0]);

    }
}
