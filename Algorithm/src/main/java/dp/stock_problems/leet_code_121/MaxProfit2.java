package dp.stock_problems.leet_code_121;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/30 23:06
 * @Desc :
 * 题解：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
 */
public class MaxProfit2 {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};

        MaxProfit2 maxProfit = new MaxProfit2();
        int result = maxProfit.maxProfit(nums);
        System.err.println("result : "+result);
    }


    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            res = Math.max(res, price - minPrice);

        }
        return res;
    }
}
