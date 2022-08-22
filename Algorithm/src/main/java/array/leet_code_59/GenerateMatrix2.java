package array.leet_code_59;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/22 21:46
 * @Desc :
 */
public class GenerateMatrix2 {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int[][] mat = new int[n][n];
        int target = n * n;
        int start = 1;
        while (start <= target) {
            // left to right;
            for (int i = left; i <= right; i++) {
                mat[top][i] = start++;
            }
            top++;
            // top to bottom;
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = start++;
            }
            right--;

            // right to left;
            for (int i = right; i >= left; i--) {
                mat[bottom][i] = start++;
            }
            bottom--;

            // bottom to top
            for (int i = bottom; i >= top; i--) {
                mat[i][left] = start++;
            }
            left++;

        }

        return mat;


    }
}
