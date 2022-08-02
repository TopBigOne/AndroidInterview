package array.leet_code_48;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/2 18:40
 * @Desc :
 */
public class Rotate3 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                int rightUp = matrix[i][j];
                int leftBottom = matrix[j][i];

                matrix[i][j] = leftBottom;
                matrix[j][i] = rightUp;
            }

        }
        int mid = n >>> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }

    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int leftBottom = matrix[i][j];
                int rightTop = matrix[j][i];
                matrix[i][j] = rightTop;
                matrix[j][i] = leftBottom;
            }

        }
        int mid = n >>> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;

            }
        }


    }
}
