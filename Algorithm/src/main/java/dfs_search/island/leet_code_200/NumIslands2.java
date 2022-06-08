package dfs_search.island.leet_code_200;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/24 11:32
 * @Desc : https://leetcode-cn.com/problems/number-of-islands/submissions/
 *
 * <p>
 * 李伟伟：bfs 解法：https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
 */
public class NumIslands2 {
    public int numIslands(char[][] grid) {
        int res = 0;
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dfsGrid(grid, i, j);
                res++;
            }
        }
        return res;
    }

    private void dfsGrid(char[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length) {
            return;
        }
        if (grid[row][column] != '1') {
            return;
        }

        grid[row][column]  = '2';
        dfsGrid(grid, row+1, column);
        dfsGrid(grid, row-1, column);
        dfsGrid(grid, row, column+1);
        dfsGrid(grid, row, column-1);


    }


}
