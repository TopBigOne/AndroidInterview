package dp;

/**
 * @author : dev
 * @version :
 * @Date :  1/12/21 12:07 AM
 * @Desc :  动态规划（DP：dynamic programming），这里抛开动态规划严格且抽象的定义，我们从它的实现方式入手，也即记录结果再利用，我们来看动态规划版本的计算方法：
 * 换钱的最少货币：
 * arr = [5,2,3],aim = 20;
 */
public class Demo_4_MinCoin {


    public int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0] + 1];
            }
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }

        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }
}
