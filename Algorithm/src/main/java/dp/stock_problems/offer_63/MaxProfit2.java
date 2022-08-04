package dp.stock_problems.offer_63;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/30 17:49
 * @Desc : 股票的最大利润：https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class MaxProfit2 {
    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        // dp[i][0]   持有股票
        // dp[i][1]   卖了股票: 第i天不持有股票所得最多现金
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            // 持有,
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // 卖掉
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
            System.out.println("DP : " + Arrays.deepToString(dp));
        }
        return dp[len - 1][1];

    }
}
