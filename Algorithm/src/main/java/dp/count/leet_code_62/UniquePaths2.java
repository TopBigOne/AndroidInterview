package dp.count.leet_code_62;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/3 19:41
 * @Desc :
 */
public class UniquePaths2 {
    public int uniquePath(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];

    }
}
