package dp.leet_code_446;

import java.util.HashMap;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/15 23:08
 * @Url : https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/
 * @Level :     hard
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/solution/dong-tai-gui-hua-java-by-liweiwei1419-jc84/
 */
public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) return 0;
        HashMap<Long, Integer>[] dp = new HashMap[len];
        for (int i = 0; i < len; i++) {
            dp[i] = new HashMap<>();
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue;
                }
                int value = dp[i].getOrDefault(diff, 0) + dp[j].getOrDefault(diff, 0) + 1;
                dp[i].put(diff, value);

                if (dp[j].containsKey(diff)) {
                    res += dp[j].get(diff);
                }
            }
        }
        return res;
    }
}
