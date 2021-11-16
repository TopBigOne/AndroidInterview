package dp.leet_code_629;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/14 21:01
 * @Url : https://leetcode-cn.com/problems/k-inverse-pairs-array/
 * @Level :     hard
 * @Desc :
 * @Counter : 3
 * @Answer : https://leetcode-cn.com/problems/k-inverse-pairs-array/solution/gong-shui-san-xie-yi-dao-xu-lie-dp-zhuan-tm01/
 */
public class KInversePairs {
    public int kInversePairs(int n, int k) {
        int mod = (int) (1e9 + 7);
        int[][] f = new int[n + 1][k + 1];
        int[][] sum = new int[n + 1][k + 1];
        f[1][0] = 1;
        Arrays.fill(sum[1], 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j < i) {
                    int valueOne = sum[i - 1][j];
                    f[i][j] = valueOne;
                }

                if (j >= i) {
                    int valueTwo = sum[i - 1][j] - sum[i - 1][j - (i - 1) - 1] + mod;
                    f[i][j] = valueTwo % mod;
                }

                sum[i][j] = j == 0 ? f[i][j] : (sum[i][j - 1] + f[i][j]) % mod;
            }
        }
        return f[n][k];
    }


}
