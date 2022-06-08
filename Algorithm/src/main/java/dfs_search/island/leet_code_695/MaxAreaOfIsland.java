package dfs_search.island.leet_code_695;

/**
 * @author : dev
 * @version :
 * @Date :  7/4/21 5:08 PM
 * @Desc :  leet code 岛屿的最大面积：https://leetcode-cn.com/problems/max-area-of-island/
 * <p>
 * <p>
 * <p>
 * 题解：https://leetcode-cn.com/problems/max-area-of-island/solution/fang-ge-lei-dfs-de-jian-dan-fang-fa-cjava-by-nette/
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int row;
        int col;
        if (grid == null || (row = grid.length) == 0 || (col = grid[0].length) == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int currValue = grid[i][j];
                //  1 是岛屿
                if (currValue == 1) {
                    int temp = area(grid, i, j);
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }

    private int area(int[][] grid, int row, int col) {
        if (row < 0 || col < 0
                || row >= grid.length
                || col >= grid[0].length) {
            return 0;
        }


        if (grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = 2;

        return 1
                + area(grid, row, col - 1)
                + area(grid, row, col + 1)
                + area(grid, row + 1, col)
                + area(grid, row - 1, col);
    }
}
