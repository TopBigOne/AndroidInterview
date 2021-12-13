package array.leet_code_1034;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/7 23:01
 * @Url :https://leetcode-cn.com/problems/coloring-a-border/solution/
 * @Level :    medium
 * @Desc : 边界着色
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/coloring-a-border/solution/gong-shui-san-xie-tu-lun-sou-suo-zhuan-t-snvw/
 */
public class ColorBorder {
    /**
     * BFS
     * @param grid
     * @param row
     * @param col
     * @param color
     * @return
     */
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        int[][] dirs = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1},
        };
        Deque<int[]> d = new ArrayDeque<>();
        d.addLast(new int[]{row, col});

        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            int x = poll[0];
            int y = poll[1];
            int cnt = 0;

            for (int[] di : dirs) {
                int nx = x + di[0];
                int ny = y + di[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (grid[x][y] != grid[nx][ny]) {
                    continue;
                }
                cnt++;
                if (ans[nx][ny] != 0) {
                    continue;
                }
                d.addLast(new int[]{nx, ny});
            }
            ans[x][y] = cnt == 4 ? grid[x][y] : color;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 0) {
                    ans[i][j] = grid[i][j];
                }
            }
        }
        return ans;

    }

    public int[][] colorBorder2(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> d = new ArrayDeque<>();
        d.addLast(new int[]{row, col});
        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            int x = poll[0], y = poll[1], cnt = 0;
            for (int[] di : dirs) {
                int nx = x + di[0], ny = y + di[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (grid[x][y] != grid[nx][ny]) {
                    continue;
                } else {
                    cnt++;
                }
                if (ans[nx][ny] != 0) {
                    continue;
                }
                d.addLast(new int[]{nx, ny});
            }
            ans[x][y] = cnt == 4 ? grid[x][y] : color;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 0) ans[i][j] = grid[i][j];
            }
        }
        return ans;


    }
}
