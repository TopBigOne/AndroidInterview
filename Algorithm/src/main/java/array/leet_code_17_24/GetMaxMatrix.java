package array.leet_code_17_24;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/19 23:09
 * @Url :  https://leetcode-cn.com/problems/max-submatrix-lcci/
 * @Level :  hard
 * @Desc : 最大子矩阵
 * @Counter : 2
 * @Answer : https://leetcode-cn.com/problems/max-submatrix-lcci/solution/zhe-yao-cong-zui-da-zi-xu-he-shuo-qi-you-jian-dao-/
 */
public class GetMaxMatrix {
    public int[] getMaxMatrix(int[][] matrix) {
        int[] ans = new int[4];
        int N = matrix.length;
        int M = matrix[0].length;
        int[] b = new int[M];
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int bestr1 = 0;
        int bestc1 = 0;
        for (int i = 0; i < N; i++) {
            Arrays.fill(b, 0);

            for (int j = i; j < N; j++) {
                sum = 0;
                for (int k = 0; k < M; k++) {
                    b[k] += matrix[j][k];

                    if (sum > 0) {
                        sum += b[k];
                    } else {
                        sum = b[k];
                        bestr1 = i;
                        bestc1 = k;
                    }


                    if (sum > maxSum) {
                        maxSum = sum;
                        ans[0] = bestr1;
                        ans[1] = bestc1;
                        ans[2] = j;
                        ans[3] = k;
                    }
                }
            }
        }
        return ans;

    }

}
