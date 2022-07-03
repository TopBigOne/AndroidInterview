package dfs_search.island.leet_code_200;

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

    private final char LAND = '1';

    /**
     * DFS 解法
     * 0: 表示"陆地"；
     * 1: 表示"水域"；
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int res = 0;


        //1：两层 for 循环就是为了找小岛
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == LAND) {
                    // 只要找到了一个land，就要把此时 land 水平和竖直方向的 land 都找到；
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        // 边界条件
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) {
            return;
        }

        //  不是陆地
        if (grid[i][j] != LAND) {
            return;
        }

        // 标注：表示走过；
        grid[i][j] = '2';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);

    }


}
