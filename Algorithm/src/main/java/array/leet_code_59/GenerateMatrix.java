package array.leet_code_59;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/16 23:11
 * @Desc :
 * 题解：https://leetcode.cn/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int[][] mat = new int[n][n];
        int num = 1;
        int tar = n * n;
        while (num <= tar) {
            // left to right.
            for (int i = left; i <= right; i++) {
                mat[top][i] = num++;
            }
            top++;

            // top to bottom.
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = num++;
            }
            right--;

            // right to left.
            for (int i = right; i >= left; i--) {
                mat[bottom][i] = num++;
            }
            bottom--;

            // bottom to top.
            for (int i = bottom; i >= top; i--) {
                mat[i][left] = num++;
            }
            left++;



        }
        return mat;


    }
}
