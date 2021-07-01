package n_sum.leet_code_15;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.HTMLWriter;

/**
 * @author : dev
 * @version :
 * @Date :  7/2/21 1:28 AM
 * @Desc : https://leetcode-cn.com/problems/3sum/
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        int len = nums.length;
        if (len < 3) {
            return result;
        }

        // 从小到大
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 1：别忘记了，我们的目的是三数之和；
            if (nums[i] > 0) {
                break;
            }
            // 2：去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 左右指针
            int l = i + 1;
            int r = len - 1;
            // find
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 去重
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
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
                    continue;
                }
            }


        }
        return result;

    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return result;
        }
        if (len < 3) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 1: 大于 0 判断,减少不必要的遍历
            if (nums[i] > 0) {
                break;
            }
            //  去重
            if (i > 0 && nums[i] == nums[i + 1]) {
                continue;
            }

            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                    continue;
                }
                if (sum > 0) {
                    r--;
                    continue;
                }
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                    continue;
                }
            }
        }
        return result;


    }
}
