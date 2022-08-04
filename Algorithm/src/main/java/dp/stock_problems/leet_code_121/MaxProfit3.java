package dp.stock_problems.leet_code_121;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/1 11:31
 * @Desc :
 * <p>
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
 * <p>
 * 总结：https://leetcode.cn/circle/article/qiAgHn/
 */
public class MaxProfit3 {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        MaxProfit3 maxProfit = new MaxProfit3();
        int result = maxProfit.maxProfit(nums);
        System.err.println("result : " + result);
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {

            // 第i天不持有 由
            // 第i-1天不持有然后不操作
            // 和
            // 第i-1天持有然后卖出
            // 两种情况的最大值转移过来
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 买了这一只股票
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            System.err.println("dp : " + Arrays.deepToString(dp));
        }
        return dp[len - 1][0];
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            // dp[i - 1][1] + prices[i]: 昨天持股，今天卖掉
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // -prices[i] :昨天不持股，今天持股
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);

        }
        return dp[len - 1][0];

    }

    public int maxProfit3(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        //不持有股票
        dp[0][0] = 0;
        // 持有股票
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            // dp[i-1][0]： 昨天不持股，今天依旧不持股
            // dp[i-1][1] + prices[i] ：昨天持股，今天卖掉
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // - prices[i]： 昨天不持股，今天买点股票
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);

        }
        return dp[len - 1][0];
    }
}
