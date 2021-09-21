package array.leet_code_48;


/**
 * @author :  dev
 * @version :
 * @Date : 2021/9/7 20:32
 * @Url : https://leetcode-cn.com/problems/rotate-image/
 * @Level :  medium
 * @Desc : 旋转图像:给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * @Counter : 8
 * @Answer :https://leetcode-cn.com/problems/rotate-image/solution/ji-qiao-ti-zai-zeng-song-yi-wei-xing-shi-377z/
 */
public class Rotate2 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {
            // 先以对角线为轴进行翻转
            for (int j = i + 1; j < n; j++) {
                int leftDown = matrix[i][j];
                int rightUp = matrix[j][i];
                matrix[i][j] = rightUp;
                matrix[j][i] = leftDown;
            }
        }

        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
