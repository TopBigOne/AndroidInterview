package array.sub_array.leet_code_560;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/11 14:04
 * @Desc :
 */
public class SubarraySum4 {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            count += preSumMap.getOrDefault(preSum - k, 0);
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
