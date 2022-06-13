package math.offer_14_1;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/11 17:30
 * @Desc :
 *
 * https://leetcode.cn/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/
 * <p>
 * 题解：https://leetcode.cn/problems/integer-break/solution/tan-xin-xuan-ze-xing-zhi-de-jian-dan-zheng-ming-py/
 */
public class CuttingRope {

    public static void main(String[] args) {
        CuttingRope cuttingRope = new CuttingRope();
        int result = cuttingRope.cuttingRope(5);
        System.err.println("result  : " + result);
    }

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        // 初始化
        dp[1] = 1;
        // 递推开始
        for (int i = 2; i <= n; i++) {
            // 其中一个加法因子至少是 1，最多是 i - 1
            for (int j = 1; j <= i - 1; j++) {
                // j*(i-j)表示 ： 把i拆分为j和i-j两个数相乘
                // j*dp[i-j]表示把i拆分成j和继续把(i-j)这个数拆分，取(i-j)拆分结果中的最大乘积与j相乘
                int temp = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(dp[i], temp);
                System.err.println(" dp[" + i + "] : " + dp[i]);
            }
        }
        return dp[n];


    }
}
