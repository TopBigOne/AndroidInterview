package dp.leet_code_221;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/3 17:09
 * @Desc : leetcode-221:最大正方形 ：https://leetcode-cn.com/problems/maximal-square/
 * <p>
 * 题解：https://www.youtube.com/watch?v=grfZlZT03mM
 */
public class MaximalSquare2 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int slide = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    int top = dp[i][j - 1];
                    int leftTop = dp[i - 1][j - 1];
                    int left = dp[i - 1][j];
                    dp[i][j] = Math.min(top, Math.min(leftTop, left)) + 1;
                    slide = Math.max(slide, dp[i][j]);
                }
            }
        }

        return (int) Math.pow(slide, 2);


    }

    public int maximalSquare2(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    int top = dp[i][j - 1];
                    int leftTop = dp[i - 1][j - 1];
                    int left = dp[i - 1][j];
                    dp[i][j] = Math.min(Math.min(top, leftTop), left) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return (int) Math.pow(res, 2);
    }
}
