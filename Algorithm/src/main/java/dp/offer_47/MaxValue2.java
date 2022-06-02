package dp.offer_47;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/31 18:21
 * @Desc :礼物的最大值：https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class MaxValue2 {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int currValue = grid[i][j];
                int preLeftValue = dp[i - 1][j];
                int preTopValue = dp[i][j - 1];

                dp[i][j] = Math.max(preLeftValue, preTopValue) + currValue;
            }
        }
        return dp[m - 1][n - 1];

    }

    public int maxValue2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = grid[0][0];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int currValue = grid[i - 1][j - 1];
                // 已经计算出来了；
                int preLeftValue = dp[i - 1][j];
                int preTopValue = dp[i][j - 1];
                dp[i][j] = Math.max(preLeftValue, preTopValue) + currValue;

            }
        }

        return dp[m][n];


    }
}
