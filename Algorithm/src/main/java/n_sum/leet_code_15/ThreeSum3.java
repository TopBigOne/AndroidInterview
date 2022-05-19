package n_sum.leet_code_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/17 18:15
 * @Desc :  https://leetcode.cn/problems/3sum/submissions/
 */
public class ThreeSum3 {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int len;
        if (nums == null || (len = nums.length) < 3) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = len - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                    continue;
                }
                if (sum > 0) {
                    r--;
                    continue;
                }
                if (sum < 0) {
                    l++;
                }

            }
        }
        return result;


    }
}
