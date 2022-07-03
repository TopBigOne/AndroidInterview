package dfs_search.island.leet_code_200;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/3 17:58
 * @Desc :
 */
public class NumIslands6 {

    private final char LAND = '1';
    int res = 0;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == LAND) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] != LAND) {
            return;
        }

        grid[i][j] = '*';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);

        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);


    }
}
