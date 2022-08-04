package dp.stock_problems.offer_63;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/30 15:45
 * @Desc :
 * <p>
 * https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/solution/gu-piao-de-zui-da-li-run-dong-tai-gui-hu-4avf/
 */
public class MaxProfit {
    public static void main(String[] args) {
        //int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {7, 6, 4, 3, 1};
        MaxProfit maxProfit = new MaxProfit();
        int result = maxProfit.maxProfit(prices);
        System.err.println("result : " + result);
    }

    /**
     * 暴力解法
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 0;
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 每一步的最小花费
                minCost = Math.min(minCost, prices[j]);
                int val = prices[i] - minCost;
                dp[i] = Math.max(dp[i - 1], val);
            }
        }
        System.out.println("dp :" + Arrays.toString(dp));
        return dp[len - 1];

    }

    /**
     * 非常人性的思考方式；
     * 贪心 : 每一步，最多，结果就是最多的！
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            result = Math.max(result, price - cost);
        }
        return result;
    }
}
