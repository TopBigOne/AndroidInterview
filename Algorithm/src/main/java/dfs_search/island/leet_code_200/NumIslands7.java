package dfs_search.island.leet_code_200;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/2 19:23
 * @Desc :
 */
public class NumIslands7 {

    char land = '1';
    char used = '*';

    public int numIslands(char[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == land) {
                    dfs(matrix, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return;
        }
        if (matrix[i][j] != land) {
            return;
        }
        matrix[i][j] = used;
        dfs(matrix, i + 1, j);
        dfs(matrix, i - 1, j);
        dfs(matrix, i, j - 1);
        dfs(matrix, i, j + 1);
    }


}
