package n_sum.leet_code_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/29 23:08
 * @Desc :
 */
public class ThreeSum4 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = 0;
        if (nums == null || (len = nums.length) < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int one = nums[i];
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = one + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(one, nums[l], nums[r]));
                    // 再次去重
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
                if (sum < 0) {
                    l++;
                    continue;
                }
                if (sum > 0) {
                    r--;
                }
            }

        }
        return res;


    }

    public List<List<Integer>> threeSum2(int[] nums) {
        int len;
        int scope = 3;
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || (len = nums.length) < scope) {
            return res;
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
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // skip the duplicate element;
                    while (l < r && nums[l] == nums[l+ 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                    continue;
                }
                if (sum < 0) {
                    l++;
                    continue;
                }
                if (sum > 0) {
                    r--;
                }
            }
        }
        return res;


    }
}
