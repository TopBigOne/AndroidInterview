package dfs_search.island.leet_code_200;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/3 17:05
 * @Desc :
 */
public class NumIslands5 {


    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        NumIslands5 numIslands = new NumIslands5();
        System.err.println(" start : ");
        System.err.println(Arrays.deepToString(grid));
        int result = numIslands.numIslands(grid);
        System.err.println("result : " + result);

        System.err.println(" end : ");
        System.err.println(Arrays.deepToString(grid));

    }

    private final char LAND = '1';

    public int numIslands(char[][] grid) {
        int res = 0;
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
        if (i < 0 ||
                j < 0 ||
                i >= grid.length ||
                j >= grid[0].length) {
            return;

        }
        if (grid[i][j] != LAND) {
            return;
        }
        grid[i][j] = '2';

        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);

    }


}
