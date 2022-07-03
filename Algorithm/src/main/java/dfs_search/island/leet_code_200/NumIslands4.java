package dfs_search.island.leet_code_200;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/3 16:49
 * @Desc :
 */
public class NumIslands4 {


    private final char LAND = '1';

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == LAND) {
                    dfsGris(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfsGris(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) {
            return;
        }
        if(grid[i][j] != LAND){
            return;
        }

        grid[i][j] = '2';

        dfsGris(grid, i, j - 1);
        dfsGris(grid, i, j + 1);
        dfsGris(grid, i + 1, j);
        dfsGris(grid, i - 1, j);
    }



}
