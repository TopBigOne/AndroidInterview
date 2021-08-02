package array.leet_code_48;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/29 21:21
 * @Url : https://leetcode-cn.com/problems/rotate-image/
 * @Level :  medium
 * @Desc : 旋转图像:给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * @Counter : 8
 * @Answer :https://leetcode-cn.com/problems/rotate-image/solution/ji-qiao-ti-zai-zeng-song-yi-wei-xing-shi-377z/
 */
public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Rotate rotate = new Rotate();
        rotate.rotate(matrix);


    }

    /**
     * [1,2,3]
     * [4,5,6]
     * [7,8,9]
     * --------------------------------
     * 你看看：以：1，5，9这3个数为斜线，
     * 然后： 1 不动，2和4 交换，3和7 交换，8和6 交换，9 不动；
     * [1,4,7]
     * [2,5,8]
     * [3,6,9]
     * --------------------------------
     * 然后 以重点 进行一次 翻转
     * [7,4,1]
     * [8,5,2]
     * [9,6,3]
     */
    public void rotate(int[][] matrix) {
        System.out.println("|------------------------------------------------------------|");
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {

            // 先以对角线为轴进行翻转
            for (int j = i + 1; j < n; j++) {
                int leftDown = matrix[i][j];
                int rightUp = matrix[j][i];
                System.out.println("  leftDown : " + leftDown + " , rightDown : " + rightUp);
                System.out.println("|------------------------------------------------------------|");
                int temp = leftDown;
                matrix[i][j] = rightUp;
                matrix[j][i] = temp;

            }

        }

        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                // 我靠，从后往前减少...
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }

    }


}
