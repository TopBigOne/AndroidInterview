package dp.leet_code_740;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/15 23:22
 * @Url : https://leetcode-cn.com/problems/delete-and-earn/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/delete-and-earn/solution/ru-guo-ni-li-jie-liao-da-jia-jie-she-zhe-ti-ni-ken/
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] all = new int[max + 1];
        for (int item : nums) {
            all[item]++;
        }
        int[] dp = new int[max + 1];
        dp[1] = all[1];
        dp[2] = Math.max(dp[1], dp[2] * 2);
        // 动态规划求解
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
        }
        return dp[max];
    }
}
