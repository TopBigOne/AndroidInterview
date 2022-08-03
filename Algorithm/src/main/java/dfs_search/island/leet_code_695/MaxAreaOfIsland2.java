package dfs_search.island.leet_code_695;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/3 21:08
 * @Desc :  leet code 岛屿的最大面积：https://leetcode-cn.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland2 {

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    int temp = dfs(grid, i, j);
                    res = Math.max(res, temp);
                }
            }
        }
        return res;

    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return 1 +
                dfs(grid, i + 1, j) +
                dfs(grid, i - 1, j) +
                dfs(grid, i, j + 1) +
                dfs(grid, i, j - 1);


    }
}
