package tree.dfs.island.leet_code_200;

/**
 * @author : dev
 * @version :
 * @Date :  7/4/21 6:42 PM
 * @Desc :
 */
public class NumIslands3 {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int cloumn = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cloumn; j++) {
                // 找到了陆地
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);

    }
}
