package fib.leet_code_509;

/**
 * @author : dev
 * @version :
 * @Date :  2022/9/1 22:54
 * @Desc :
 */
public class Fibonacci2 {
    public int fib(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;


        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
