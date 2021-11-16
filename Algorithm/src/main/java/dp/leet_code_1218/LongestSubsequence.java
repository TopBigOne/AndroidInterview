package dp.leet_code_1218;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/15 22:01
 * @Url : https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :  https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/solution/tong-ge-lai-shua-ti-la-dong-tai-gui-hua-ue2q9/
 */
public class LongestSubsequence {
    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 8, 10};
        LongestSubsequence longestSubsequence = new LongestSubsequence();
        int result = longestSubsequence.longestSubsequence2(nums, 2);
        System.out.println("result :" + result);


    }

    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        int[] dp = new int[40001];
        for (int num : arr) {
            dp[num + 20000] = dp[num + 20000 - difference] + 1;
            ans = Math.max(ans, dp[num + 20000]);
        }
        return ans;
    }

    public int longestSubsequence2(int[] arr, int difference) {
        int ans = 0;
        int[] dp = new int[40001];
        int p = 20000;

        for (int num : arr) {
            int index = num + p;
            dp[index] = dp[index - difference] + 1;
            ans = Math.max(ans, dp[num + p]);
        }
        return ans;

    }
}
