package dp.stock_problems.leet_code_188;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/1 15:21
 * @Desc :   188. 买卖股票的最佳时机 IV  https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 * <p>
 * 牛逼的题解：
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/solution/yi-chong-ji-yu-wqs-er-fen-de-you-xiu-zuo-x36r/
 */
public class MaxProfit {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        if (k >= length / 2) {
            return maxProfit(prices);
        }


        int[][][] dp = new int[length][k + 1][2];
        // 交易次数
        for (int i = 1; i <= k; i++) {

            // 不持有股票：
            dp[0][i][0] = 0;
            // 持有股票：
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < length; i++) {
            // 交易次数
            for (int j = k; j > 0; j--) {
                // 不持有股票
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);

                // 持有股票
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[length - 1][k][0];

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit0 = 0;
        int profit1 = -prices[0];
        int length = prices.length;

        for (int i = 1; i < length; i++) {
            int newProfit0 = Math.max(profit0, profit1 + prices[i]);
            int newProfit1 = Math.max(profit1, profit0 - prices[i]);
            profit0 = newProfit0;
            profit1 = newProfit1;
        }
        return profit0;
    }

}
