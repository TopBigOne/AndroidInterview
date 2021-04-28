package array.leet_code_121;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/27 10:58
 * @Desc : 121-买卖股票的最佳时机 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/submissions/
 *
 */
public class MaxProfit {
    /**
     * 暴力解法，经不住的复杂的测试用例
     * 暴力解法，，它香啊。。。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // base case;
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int right = prices[j];
                int left = prices[i];
                System.out.println("组合：right : " + right + ", left : " + left);
                max = Math.max(max, right - left);
            }
        }
        return max;
    }


    /**
     * 贪心算法
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        // base case;
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int minVal = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            if (minVal > price) {
                minVal = price;
            }
            int temp = price - minVal;
            if (temp > res) {
                res = temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // [7,1,5,3,6,4]

        int[] rawData = {7, 1, 5, 3, 6, 4};
        MaxProfit maxProfit = new MaxProfit();
        int result = maxProfit.maxProfit(rawData);
        System.out.println(result);


    }
}
