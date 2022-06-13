package packsack.leet_code_377;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/25 23:03
 * @Url : https://leetcode-cn.com/problems/combinatxion-sum-iv/description/
 * @Level :    medium
 * @Desc : 组合总和IV
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/combination-sum-iv/solution/xi-wang-yong-yi-chong-gui-lu-gao-ding-bei-bao-wen-/
 */
public class CombinationSum {
    /**
     * 组合问题
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
