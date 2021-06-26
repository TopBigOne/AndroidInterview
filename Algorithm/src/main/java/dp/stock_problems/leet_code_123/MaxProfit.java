package dp.stock_problems.leet_code_123;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/26 17:27
 * @Url :  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * @Level :  hard
 * @Desc :
 * @Counter : 6
 * @Answer :
 */
public class MaxProfit {
    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/dong-tai-gui-hua-by-liweiwei1419-7/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        // i : 在[0,1]的区间内，可进行的交易
        // j : 0， 没有交易；1，交易1次；2，交易2次；
        // k : 0,当前不持股，1，当前持股；
        int[][][] dp = new int[len][3][2];
        // 理解如下初始化：
        // 第三维规定了必须持股，因此-prices[0];
        dp[0][1][1] = -prices[0];
        // 还没有发生的交易，持股的时候应该初始化为负无穷
        dp[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            int curPrice = prices[i];
            // 转移顺序，先持股，再卖出
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -curPrice);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + curPrice);
            // 第二笔交易，持股状态
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - curPrice);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + curPrice);
        }
        return Math.max(dp[len - 1][1][0], dp[len - 1][2][0]);
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int dp[][][] = new int[len][3][2];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            int curPrice = prices[i];
            // 第一次交易
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -curPrice);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + curPrice);

            // 第二次交易
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - curPrice);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + curPrice);

        }

        return Math.max(dp[len - 1][1][0], dp[len - 1][2][0]);
    }
}
