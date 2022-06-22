package dp.sub_sequence.leet_code_718;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/22 00:57
 * @Desc :
 * <p>
 * 718. 两个数组，找到他们 最长重复子数组 : https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * <p>
 * <p>
 * 题解：https://leetcode.cn/problems/maximum-length-of-repeated-subarray/solution/javadong-tai-gui-hua-jie-jue-qi-shi-jiu-shi-zui-ch/
 */
public class FindLength {

    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public int findLength2(int[] nums1, int[] nums2) {
        int max = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

}
