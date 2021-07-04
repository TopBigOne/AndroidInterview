package tree.dfs.island.leet_code_200;

/**
 * @author : dev
 * @version :
 * @Date :  3/24/21 1:35 AM
 * @Desc : 岛屿的数量 字节：35 次  https://leetcode-cn.com/problems/number-of-islands/solution/
 * 200. 岛屿数量      （Easy）
 * 463. 岛屿的周长        （Easy）
 * 695. 岛屿的最大面积    （Medium）
 * 827. 最大人工岛       （Hard）
 * <p>
 * 题解：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 * 一姐：https://www.youtube.com/watch?v=Ft0AmONMYyM&t=5s
 */
public class NumIslands {
    /**
     * DFS 解法
     * 0: 表示"陆地"；
     * 1: 表示"水域"；
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        int row = grid.length;
        int column = grid[0].length;
        char land = '1';

        //1：两层 for 循环就是为了找小岛
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                if (grid[i][j] == land) {
                    // 只要找到了一个land，就要把此时 land 水平和竖直方向的 land 都找到；
                    dfsGird(grid, i, j);
                    res++;
                }

            }
        }
        return res;
    }

    private void dfsGird(char[][] grid, int row, int column) {
        if (row >= grid.length || column >= grid[0].length || row < 0 || column < 0) {
            return;
        }

        if (grid[row][column] != '1') {
            return;
        }

        // 标注：走过；
        grid[row][column] = '2';
        dfsGird(grid, row - 1, column);
        dfsGird(grid, row + 1, column);
        dfsGird(grid, row, column - 1);
        dfsGird(grid, row, column + 1);

    }
}
