package dp.stock_problems.leet_code_309;

/**
 * @author : dev
 * @version :
 * @Date :  6/28/21 11:52 PM
 * @Desc :  leetcode : 字节 5 次 ： https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * <p>
 * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 题解:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/fei-zhuang-tai-ji-de-dpjiang-jie-chao-ji-tong-su-y/
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][4];
        // 不持有股票，没卖出去的
        dp[0][0] = 0;
        // 不持有股票，卖出去了
        dp[0][1] = 0;
        // 持有股票，今天买入
        dp[0][2] = -prices[0];
        // 持有股票，非今天买入
        dp[0][3] = -prices[0];
        for (int i = 1; i < len; i++) {
            int currPrice = prices[i];

            // 前天不持有股票的两种情况最大值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // 今天卖出股票，来找前一天持有股票的最大值
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][3] )+ currPrice;
            // 今天买入股票，这前一天一定没有卖出股票
            dp[i][2] = dp[i - 1][0] - currPrice;
            // 今天没有买股票，却持有股票，前一天继承来的，有两种情况
            dp[i][3] = Math.max(dp[i - 1][2], dp[i - 1][3]);

        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);


    }
}
