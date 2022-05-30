package dp.offer_10_1;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/30 14:19
 * @Desc :
 */
public class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        int result = fib.fib(7);
        System.err.println(result);

    }

    public int fib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        if (n >= 1) {
            dp[1] = 1;
        }

        // dp[n] = dp[n-1]+d[n-2];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1e9 + 7;
        }

        return dp[n];

    }
}
