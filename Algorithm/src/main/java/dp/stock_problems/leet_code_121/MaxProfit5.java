package dp.stock_problems.leet_code_121;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/4 15:12
 * @Desc : https://leetcode.cn/circle/article/qiAgHn/
 */
public class MaxProfit5 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // dp[i][0] 不持有股票最大收益
        // dp[i][1]  持有股票最大收益
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // dp[i - 1][0] 昨天不持股，今天什么都不做；
            // dp[i - 1][1] + prices[i] :昨天持股，今天卖出股票（现金数增加）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // dp[i - 1][1] :昨天持股，今天什么都不做（现金数与昨天一样）；
            // -prices[i]:昨天不持股，今天买入股票（注意：只允许交易一次，因此手上的现金数就是当天的股价的相反数）。
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            int currPrice = prices[i];

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + currPrice);
            dp[i][1] = Math.max(dp[i - 1][1], -currPrice);

        }
        return dp[len - 1][0];


    }
}
