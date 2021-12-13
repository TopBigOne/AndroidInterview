package tan_xin.leet_code_807;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  12/13/21 7:16 PM
 * @Desc : 保持城市的天际线 https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/
 * <p>
 * https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/solution/gong-shui-san-xie-jian-dan-tan-xin-yun-y-2f47/
 */
public class MaxIncreaseKeepingSkyline {
    public static void main(String[] args) {
        int[][] grid = {
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };

        int[][] gridNew = {
                {8, 4, 8, 7},
                {7, 4, 7, 7},
                {9, 4, 8, 7},
                {3, 3, 3, 3}
        };

        MaxIncreaseKeepingSkyline skyline = new MaxIncreaseKeepingSkyline();
        int result = skyline.maxIncreaseKeepingSkyline(grid);
        System.out.println("result : " + result);

    }

    /**
     * 从「水平」和「竖直」两个方向所看到的「行」和「列」的最大高度不变。
     *
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] r = new int[n];
        int[] c = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 每一行和每一列的最大值
                r[i] = Math.max(r[i], grid[i][j]);
                c[j] = Math.max(c[j], grid[i][j]);
            }
        }

        System.out.println("每一行的最大值 : " + Arrays.toString(r));
        System.out.println("每一列的最大值 : " + Arrays.toString(c));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += Math.min(r[i], c[j]) - grid[i][j];
            }
        }
        return ans;

    }

    public int maxIncreaseKeepingSkyline2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] rMax = new int[row];
        int[] cMax = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int currValue = grid[i][j];
                rMax[i] = Math.max(rMax[i], currValue);
                cMax[j] = Math.max(cMax[j], currValue);
            }
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            int rValue = rMax[i];
            for (int j = 0; j < col; j++) {
                int cValue = cMax[j];
                // 当每个位置都取得最大的增大高度（局部最优）
                ans += Math.min(rValue, cValue) - grid[i][j];
            }
        }
        return ans;
    }
}
