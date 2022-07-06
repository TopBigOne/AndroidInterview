package array.leet_code_54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/6 13:17
 * @Desc :
 */
public class SpiralOrder3 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                // {13, 14, 15, 16},
                // {17, 18, 19, 20},
        };

        SpiralOrder3 spiralOrder = new SpiralOrder3();
        List<Integer> result = spiralOrder.spiralOrder2(matrix);
        System.err.println("result : " + result);
    }

    public List<Integer> spiralOrder1(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        // corner base
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            // left ---> right
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            // top ---> bottom
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }

            if (top < bottom && left < right) {
                // In bottom :
                // right ----> left
                for (int i = right - 1; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                // bottom -----> top
                for (int i = bottom - 1; i > top; i--) {
                    res.add(matrix[i][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        System.err.println("start test 2");
        while (left <= right && top <= bottom) {
            // left ---> right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }

            // top---> bottom
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }

            if (top < bottom && left < right) {
                // right ----> left
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                // bottom ----> top
                for (int i = bottom - 1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }


}
