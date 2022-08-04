package dp.stock_problems.leet_code_122;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/26 14:36
 * @Url : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @Level : easy
 * @Desc : 买卖股票的最佳时机 II
 * @Counter : 9
 * @Answer :
 */
public class MaxProfit {
    /**
     * 上帝视角
     * 题解：https://www.youtube.com/watch?v=A8ps3L_uNFI
     * 使用贪心分段获利：
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {

            int todayPrice = prices[i];
            int yesterdayPrice = prices[i - 1];

            // 如果今天的价格大于昨天的价格，那么就在：昨天买，今天卖；
            if (todayPrice > yesterdayPrice) {
                profit += todayPrice - yesterdayPrice;
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int yesterdayPrice = prices[i - 1];
            int todayPrice = prices[i];
            if (todayPrice > yesterdayPrice) {
                profit += todayPrice - yesterdayPrice;
            }
        }

        return profit;
    }
}
