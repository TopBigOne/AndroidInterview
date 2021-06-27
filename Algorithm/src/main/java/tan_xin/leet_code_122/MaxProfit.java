package tan_xin.leet_code_122;

/**
 * @author : dev
 * @version :
 * @Date :  6/20/21 1:29 AM
 * @Desc : leetcode 122： 买卖股票的最佳时机： 字节 9 次；：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        // 0: 持有现金
        // 1：持有股票
        // 状态转移 ： 0->1->0->1->0->1->0
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
