package array.leet_code_329;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/24 12:02
 * @Desc : 矩阵中的最长递增路径 ： https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPath4 {

    int[][] dirs = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1},
    };

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        int[][] memory = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (memory[i][j] == 0) {
                    int temp = dfs(matrix, m, n, i, j, memory);
                    result = Math.max(result, temp);
                }
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int m, int n, int i, int j, int[][] memory) {
        if (memory[i][j] != 0) {
            return memory[i][j];
        }
        int ans = 1;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI >= 0 &&
                    nextJ >= 0 &&
                    nextI < m &&
                    nextJ < n &&
                    matrix[nextI][nextJ] > matrix[i][j]) {
                int temp = dfs(matrix, m, n, nextI, nextJ, memory) + 1;
                ans = Math.max(ans, temp);

            }
        }
        memory[i][j] = ans;
        return ans;
    }


}
