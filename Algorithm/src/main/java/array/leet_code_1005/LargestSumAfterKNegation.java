package array.leet_code_1005;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  12/3/21 7:57 PM
 * @Desc :
 */
public class LargestSumAfterKNegation {
    public int largestSumAfterKNegations(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }
        int res = 0;

        for (int num : nums) {
            res += num;
        }
        return res;
    }
}
