package dp.leet_code_689;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  12/8/21 8:15 PM
 * @Desc : https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays/solution/gong-shui-san-xie-jie-he-qian-zhui-he-de-ancx/
 */
public class MaxSumOfThreeSubarrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        System.out.println("sum:" + Arrays.toString(sum));

        long[][] f = new long[n + 10][4];
        for (int i = n - k + 1; i >= 1; i--) {
            for (int j = 1; j < 4; j++) {
                long temp = f[i + k][j - 1] + sum[i + k - 1] - sum[i - 1];
                f[i][j] = Math.max(f[i + 1][j], temp);
            }
        }
        int[] ans = new int[3];
        int i = 1;
        int j = 3;
        int idx = 0;
        while (j > 0) {
            long temp = f[i + k][j - 1] + sum[i + k - 1] - sum[i - 1];
            if (f[i + 1][j] > temp) {
                i++;
                continue;
            }
            ans[idx++] = i - 1;
            i += k;
            j--;
        }
        return ans;
    }

    public int[] maxSumOfThreeSubarrays2(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        long[][] f = new long[n + 10][4];
        for (int i = n - k + 1; i >= 1; i--) {
            for (int j = 1; j < 4; j++) {
                long temp = f[i + k][j - 1] + sum[i + k - 1] - sum[i - 1];
                f[i][j] = Math.max(f[i + 1][j], temp);
            }
        }
        int[] ans = new int[3];
        int i = 1, j = 3, idx = 0;
        while (j > 0) {
                 long temp = f[i + k][j - 1] + sum[i + k - 1] - sum[i - 1];
            if (f[i + 1][j] > temp) {
                i++;
                continue;
            }
            ans[idx++] = i - 1;
            i += k;
            j--;

        }
        return ans;


    }
}
