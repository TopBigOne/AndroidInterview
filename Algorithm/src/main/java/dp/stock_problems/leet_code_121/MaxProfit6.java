package dp.stock_problems.leet_code_121;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/20 23:49
 * @Desc :
 */
public class MaxProfit6 {
    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        MaxProfit6 maxProfit = new MaxProfit6();
        int result = maxProfit.maxProfit(price);
        System.err.println("result :" + result);
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];

        // dp[i][0]: 第i天---> 不持有股票
        // dp[i][1]: 第i天---> 持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            int yesterday = i - 1;
            int todayPrice = prices[i];
            dp[i][0] = Math.max(dp[yesterday][0], dp[yesterday][1] + todayPrice);

            dp[i][1] = Math.max(dp[yesterday][1], -todayPrice);

        }

        return dp[len - 1][0];


    }
}
