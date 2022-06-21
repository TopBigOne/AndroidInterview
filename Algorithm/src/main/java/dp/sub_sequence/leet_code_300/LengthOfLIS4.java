package dp.sub_sequence.leet_code_300;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/1 14:17
 * @Desc :
 *
 * https://leetcode.cn/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/
 */
public class LengthOfLIS4 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }

        }

        int res = 0;
        for (int i : dp) {
           res= Math.max(res, i);
        }
        return  res;


    }
}
