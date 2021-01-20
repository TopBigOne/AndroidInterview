package dynamic_programming.leet_code_114;

/**
 * @author : dev
 * @version :
 * @Date :  1/17/21 1:24 AM
 * @Desc : 计数型的动态规划--唯一路径
 */
public class UniquePaths {
    public int uniquePath(int m, int n) {
        int[][] f = new int[m][n];
        int i, j;
        // row: top to bottom
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                // cloum: left to right
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }


    public int uniquePath2(int m, int n) {
        int[][] f = new int[m][n];
        int i, j;
        // row:top to bottom
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                // clomn :left to right
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }

            }
        }

        return f[m - 1][n - 1];
    }


}
