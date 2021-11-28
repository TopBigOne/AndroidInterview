package n_sum.leet_code_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  6/19/21 2:44 PM
 * @Desc : leet code  18: 四数之和：  https://leetcode-cn.com/problems/4sum/
 * <p>
 * 题解：
 * https://leetcode-cn.com/problems/4sum/solution/ji-bai-9994de-yong-hu-you-dai-ma-you-zhu-shi-by-yo/
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length;
        if (nums == null || (length = nums.length) < 4) {
            return result;
        }
        // 对数组进行从小到大
        Arrays.sort(nums);

        // 定义 4 个指针，k，i，j，k 从 0 开始遍历，i 从 k+1 开始遍历，留下 j 和 h，j 指向 i+1 ，h 指向数组最大值
        for (int k = 0; k < length - 3; k++) {
            // 当 k 的值与前面的值相等时 忽略
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            // 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                break;
            }

            // 获取当前最大值，如果最大值比目标值小，说明后面越来越小，根本没戏，忽略
            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }

            // 第二次 for 循环i,初始值指向 k+1
            for (int i = k + 1; i < length - 2; i++) {
                // 当i 的值的与前面的值相等时忽略
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 定义指向 j 指向 i+1；
                int j = i + 1;
                // 定义指针 h 指向数组末尾
                int h = length - 1;
                // 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值 根本没戏
                int min = nums[k] + nums[i] + nums[j] + nums[j - 1];
                if (min > target) {
                    break;
                }

                // 获取当前最大值，如果最大值 比目标值小，说明后面越来越小的值根本没戏 忽略
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }

                // 开始 j 指针和 h 指针的表演，计算当前和，如果等于目标值，j++ 并去重，h-- 并去重，
                // 当 当前和大于目标值时 h--,
                // 当 当前和小于目标值时 j++;
                while (j < h) {

                    int curr = nums[k] + nums[i] + nums[j] + nums[h];

                    // 三个条件
                    if (curr > target) {
                        h--;
                        continue;
                    }

                    if (curr < target) {
                        j++;
                        continue;
                    }

                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && i < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                        continue;
                    }

                }
            }
        }
        return result;
    }
}
