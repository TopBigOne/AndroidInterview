package array.sub_array.leet_code_560;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  11/4/21 9:28 PM
 * @Desc : leet code 560 : 和为 k 的 https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * <p>
 * 题解：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
 */
public class SubarraySum2 {
    /**
     * 前缀和 + 哈希表优化
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            count += preSumFreq.getOrDefault(preSum - k, 0);
            // 然后更新 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0, 1);
        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;
            // 先获得前缀和为  preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }
            //然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public int subarraySum3(int[] nums, int k) {
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0, 1);
        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }
            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

}
