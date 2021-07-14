package array.leet_code_54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/22 17:58
 * @Desc :   螺旋矩阵 字节半年19次
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 题解：https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-liao-tian-yi-jian/
 */
public class SpiralOrder {
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int row = 0;
        int col = 0;

        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }

            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) {
                res.add(matrix[bottom][i]);
            }
            for (int i = bottom; i > top; i--) {
                res.add(matrix[i][left]);
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        if (left == right) {
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][left]);
            }
        }

        if (top == bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
        }
        return res;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int indexRow = 0;
        // 统计矩阵从外向内的层数，如果矩阵为空，那么它的层数至少为1层
        int layerCount = (Math.min(row, column) + 1) >> 1;
        // 从内向外，逐层打印数据
        while (indexRow < layerCount) {
            // 1： 从左到右
            for (int currColumn = indexRow; currColumn < column - indexRow; currColumn++) {
                list.add(matrix[indexRow][currColumn]);
                System.out.println("    coordinate : (" + indexRow + " , " + currColumn + " ) = " + matrix[indexRow][currColumn]);
            }

            System.out.println("result one :" + list + "-------------------|\n");

            // 2: 从上到下
            for (int currColumn = indexRow + 1; currColumn < row - indexRow; currColumn++) {
                list.add(matrix[currColumn][(column - 1) - indexRow]);
                System.out.println("    coordinate : (" + currColumn + " , " + (column - 1 - indexRow) + " ) = " + matrix[currColumn][(column - 1) - indexRow]);

            }
            System.out.println("result two :" + list + "-------------------|\n");


            // 3: 从右到左
            for (int currColumn = (column - 1) - (indexRow + 1); currColumn >= indexRow && (row - 1 - indexRow != indexRow); currColumn--) {
                list.add(matrix[(row - 1 - indexRow)][currColumn]);
                System.out.println("    coordinate : (" + (row - 1 - indexRow) + " , " + currColumn + " ) = " + matrix[(row - 1 - indexRow)][currColumn]);

            }
            System.out.println("result three :" + list + "-------------------|\n");


            // 4：从下到上
            for (int currColumn = (row - 1) - (indexRow + 1); currColumn >= indexRow + 1 && (column - 1 - indexRow) != indexRow; currColumn--) {
                list.add(matrix[currColumn][indexRow]);
                System.out.println("    coordinate : (" + currColumn + " , " + indexRow + " ) = " + matrix[currColumn][indexRow]);

            }
            System.out.println("result four :" + list + "-------------------|\n");

            System.out.println("********************************************************************\n");
            // 行增加
            indexRow++;

        }
        return list;
    }


    public List<Integer> spiralOrder3(int[][] matrix) {
        // 1: base corner
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            // 为啥敢写<=,因为 right减1了；
            for (int i = left; i <= right; i++) {
                int value = matrix[top][i];
                res.add(value);
            }

            for (int i = top + 1; i <= bottom; i++) {
                int value = matrix[i][right];
                res.add(value);
            }

            if (top < bottom && left < right) {
                // 从 (bottom,right-1)-->(bottom,left+1)
                for (int i = right - 1; i > left; i--) {
                    int value = matrix[bottom][i];
                    res.add(value);
                }
                //从(bottom,left)--->(top-1,left)
                for (int i = bottom; i > top; i--) {
                    int value = matrix[i][left];
                    res.add(value);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;

    }

    public List<Integer> spiralOrder4(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            // left-->right
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            // right-->bottom
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }

            System.out.println("    top  :" + top + ", bottom :" + bottom);
            System.out.println("    left :" + left + ",right  :" + right);
            System.out.println("|------------------------------------------|");

            // 会有相等的那一刻，要做换行或者换列处理
            if (top < bottom && left < right) {

                for (int i = right - 1; i > left; i--) {
                    res.add(matrix[bottom][i]);
                }
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

    public List<Integer> spiralOrder5(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }

            if (top < bottom && left < right) {
                for (int i = right - 1; i > left; i--) {
                    res.add(matrix[bottom][i]);
                }

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
