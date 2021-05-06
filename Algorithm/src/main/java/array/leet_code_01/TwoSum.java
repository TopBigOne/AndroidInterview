package array.leet_code_01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  5/1/21 3:17 PM
 * @Desc : 两数之和：https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> index = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            index.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            // 如果 other 存在且不是 num[i] 本身
            if (index.containsKey(other) && index.get(other) != i) {
                return new int[]{i, index.get(other)};
            }

        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> index = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            // 反过来放，
            index.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            if (index.containsKey(other) && index.get(other) != i) {
                return new int[]{i, index.get(other)};
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum3(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && map.get(other) != i) {
                return new int[]{map.get(other), i};
            }
        }

        return new int[]{-1, -1};
    }


}
