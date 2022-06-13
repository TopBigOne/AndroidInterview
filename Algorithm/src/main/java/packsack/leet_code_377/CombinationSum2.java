package packsack.leet_code_377;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/25 23:15
 * @Url : https://leetcode-cn.com/problems/combination-sum-iv/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/combination-sum-iv/solution/xi-wang-yong-yi-chong-gui-lu-gao-ding-bei-bao-wen-/
 */
public class CombinationSum2 {
    public int combinationSum2(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        // dp[i] = dp[i-nums[0]] + dp[i-nums[1]] + dp[i-nums[2]]......
        for (int i = 1; i < target+1; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];


    }
}
