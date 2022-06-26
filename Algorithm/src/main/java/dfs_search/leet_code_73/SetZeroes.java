package dfs_search.leet_code_73;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/26 01:48
 * @Desc : 矩阵置零
 * https://leetcode.cn/problems/set-matrix-zeroes/
 */
public class SetZeroes {
    public static void main(String[] args) {
             /*


       [[0, 0, 0],
       [0, 0, 0],
       [1, 0, 1]]


        * */

        int[][] matrix2 = {
                {1, 0, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        SetZeroes setZeroes = new SetZeroes();
        setZeroes.setZeroes(matrix);
        System.err.println("matrix :" + Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] isSet = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 && !isSet[i][j]) {
                    startSet(matrix, i, j, isSet);
                }
            }
        }
    }

    private void startSet(int[][] matrix, int i, int j, boolean[][] isSet) {
        int c = matrix.length;
        int r = matrix[0].length;
        for (int k = 0; k < r; k++) {
            if (matrix[i][k] != 0) {
                matrix[i][k] = 0;
                isSet[i][k] = true;
            }
        }
        for (int m = 0; m < c; m++) {
            if (matrix[m][j] != 0) {
                matrix[m][j] = 0;
                isSet[m][j] = true;
            }
        }

    }


}
