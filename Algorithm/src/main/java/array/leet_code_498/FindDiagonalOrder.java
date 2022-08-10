package array.leet_code_498;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/10 17:30
 * @Desc : 498. 对角线遍历 : https://leetcode.cn/problems/diagonal-traverse/
 */
public class FindDiagonalOrder {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        FindDiagonalOrder findDiagonalOrder = new FindDiagonalOrder();
        int[] result = findDiagonalOrder.findDiagonalOrder(mat);
        System.err.println("result : " + Arrays.toString(result));
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[] result = new int[m * n];
        int row = 0;
        int col = 0;
        int d = 0;
        // 方向
        int[][] dirs = {
                {-1, 1},
                {1, -1}
        };

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            System.err.println("curr d is :" + d);
            row += dirs[d][0];
            col += dirs[d][1];

            if (row >= m) {
                row = m - 1;
                col += 2;
                d = 1 - d;
            }
            if (col >= n) {
                col = n - 1;
                row += 2;
                d = 1 - d;
            }
            if (row < 0) {
                row = 0;
                d = 1 - d;
            }
            if (col < 0) {
                col = 0;
                d = 1 - d;
            }
        }

        return result;

    }
}
