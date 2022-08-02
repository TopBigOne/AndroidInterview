package dp.leet_code_64;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/2 12:45
 * @Desc :
 */
public class MinPathSum3 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                    continue;
                }
                int left = grid[i - 1][j];
                int top = grid[i][j - 1];

                grid[i][j] = Math.min(left, top) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];


    }
}
