package dp.stock_problems.leet_code_122;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/4 15:02
 * @Desc : leetcode 122： 买卖股票的最佳时机： 字节 9 次；：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        // 这里 0 表示持有现金（cash），1 表示持有股票（stock）。
        // 0: 持有现金
        // 1：持有股票
        // 状态转移 ： 0->1->0->1->0->1->0
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            // dp[i - 1][0]             : 前一天 没有股票
            // dp[i - 1][1] + prices[i] : 前一天 有股票，今天卖了；

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // dp[i - 1][1]: 前一天 有股票
            // dp[i - 1][0] - prices[i]: 前一天没有股票，今天买了股票；
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    public int maxProfit3(int[] prices) {

        int len;
        if (prices == null || (len = prices.length) == 0) {
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }


}
