package dp.stock_problems.leet_code_121;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/4 15:08
 * @Desc :
 */
public class MaxProfit4 {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        MaxProfit4 maxProfit = new MaxProfit4();
        int result = maxProfit.maxProfit(nums);
        System.err.println("result : " + result);
    }


    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            result = Math.max(result, price - minPrice);
        }
        return result;
    }
}
