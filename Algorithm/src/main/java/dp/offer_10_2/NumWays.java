package dp.offer_10_2;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/30 14:54
 * @Desc :
 */
public class NumWays {
    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        int result = numWays.numWays(2);
        System.err.println("result : " + result);

    }

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        // corner base
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            dp[i] %= 1e9 + 7;

        }
        return dp[n];
    }

}
