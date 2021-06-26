package dp.leet_code_64;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/24 16:14
 * @Url : https://leetcode-cn.com/problems/minimum-path-sum/submissions/
 * @Level :  medium 
 * @Desc : 64. 最小路径和
 * @Counter : 9
 * @Answer : https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int rowLen = grid.length;
        int columnLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < columnLen; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                    continue;
                }
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[rowLen - 1][columnLen - 1];
    }
}
