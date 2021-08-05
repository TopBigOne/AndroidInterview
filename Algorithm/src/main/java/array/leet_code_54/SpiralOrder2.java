package array.leet_code_54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2021/7/23 20:32
 * @Desc :   螺旋矩阵（顺时针打印矩阵） 字节半年19次
 * https://leetcode-cn.com/problems/spiral-matrix/
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 题解：https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-liao-tian-yi-jian/
 */
public class SpiralOrder2 {

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            // left--->right
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }

            // top--->bottom
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (top < bottom && left < right) {
                // in bottom: right--->left
                for (int i = right - 1; i > left; i--) {
                    res.add(matrix[bottom][i]);
                }
                // in bottom : bottom ----> top
                for (int i = bottom; i > top; i--) {
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


}
