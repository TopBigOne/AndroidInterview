package dynamic_programming.leet_code_62;

/**
 * @author : dev
 * @version :
 * @Date :  1/17/21 1:24 AM
 * @Desc : 计数型的动态规划--唯一路径
 *
 * https://leetcode-cn.com/problems/unique-paths/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *  
 *
输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下
 *
 *
 */
public class UniquePaths {
    public int uniquePath(int m, int n) {
        int[][] f = new int[m][n];
        int i, j;
        // row: top to bottom
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                // cloum: left to right
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }


    public int uniquePath2(int m, int n) {
        int[][] f = new int[m][n];
        int i, j;
        // row:top to bottom
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                // clomn :left to right
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                    continue;
                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    public int uniquePath3(int m, int n) {
        // m 行，n 列的矩阵
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                    continue;
                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m - 1][n - 1];
    }


    public int uniquePath4(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                    continue;
                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }


    public int uniquePath5(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                    continue;
                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }


    /**
     * 唯一路径
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePath6(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                    continue;
                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }


    public int uniquePath7(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                    continue;
                }
                f[i][j] = f[i][j - 1] + f[i - 1][j];
            }
        }
        return f[m - 1][n - 1];
    }


    public int uniquePath8(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                    continue;
                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m - 1][n - 1];
    }

    public int uniquePath9(int m,int n){
        int [][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0||j==0) {
                    f[i][j] = 1;
                    continue;
                }
                f[i][j] = f[i-1][j]+f[i][j-1];
            }
        }
        // 主要在 m 行，n 列处靠近目标即可！
        return f[m-1][n-1];
    }


}
