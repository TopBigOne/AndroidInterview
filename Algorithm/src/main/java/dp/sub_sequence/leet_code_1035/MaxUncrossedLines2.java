package dp.sub_sequence.leet_code_1035;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/21 23:49
 * @Desc :
 * <p>
 * 定义dp[i][j]表示数组nums1的前i个元素和nums2的前j个元素所能绘制的最大连接数，如果要求dp[i][j]，我们首先判断nums1的第i个元素和nums2的第j个元素是否相等
 * <p>
 * <p>
 * <p>
 * 如果相等，说明nums1的第i个元素可以和nums2的第j个元素可以连成一条线，这个时候nums1的前i个元素和nums2的前j个元素所能绘制的最大连接数就是nums1的前i-1个元素和nums2的前j-1个元素所能绘制的最大连接数加1，也就是dp[i][j]=dp[i-1][j-1]+1;
 * <p>
 * <p>
 * <p>
 * 如果不相等，我们就把nums1去掉一个元素，计算nums1的前i-1个元素和nums2的前j个元素能绘制的最大连接数，也就是dp[i-1][j]，或者把nums2去掉一个元素，计算nums2的前j-1个元素和nums1的前i个元素能绘制的最大连接数，也就是dp[i][j-1]，这两种情况我们取最大的即可，所以我们可以找出递推公式
 * <p>
 * https://leetcode.cn/problems/uncrossed-lines/solution/shu-ju-jie-gou-he-suan-fa-dong-tai-gui-h-duy6/
 */
public class MaxUncrossedLines2 {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {


            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    // 左右看看。
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public int maxUncrossedLines2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                // 计算一下 num1 去掉一个值，或者nums2 去掉一个值以后，能连接的最大数；
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

            }

        }

        return dp[m][n];
    }


}
