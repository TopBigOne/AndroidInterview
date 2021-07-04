package dp.stock_problems.leet_code_121;

import org.omg.CORBA.INTERNAL;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/4/27 10:58
 * @Url : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/submissions/
 * @Level : easy medium hard
 * @Desc :121-买卖股票的最佳时机
 * @Counter : 28
 * @Answer :
 * 一姐： https://www.youtube.com/watch?v=TtBmqil3EMM&t=97s
 */
public class MaxProfit {


    public static void main(String[] args) {
        // [7,1,5,3,6,4]

        int[] rawData = {7, 1, 5, 3, 6, 4};
        MaxProfit maxProfit = new MaxProfit();
        int result = maxProfit.maxProfit(rawData);
        System.out.println(result);

    }

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

    public int maxProfit3(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // 买股票能获取的最大利润
        int maxProfit = 0;
        // 找到买股票最低的价格
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {

            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }


    private int maxProfit4(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // 1: 卖股票能获取的最大利润
        int maxProfit = 0;
        // 2: 找到股票的最低价格
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    private int maxProfit5(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    private int maxProfit6(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }


}
