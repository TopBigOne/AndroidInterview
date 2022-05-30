package binary_search.search;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  2/7/21 1:07 AM
 * @Desc :
 */
public class TwoSum {
    public int[] sum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            indexMap.put(i, nums[i]);
        }

        for (int i = 0; i < length; i++) {
            int num = target - nums[i];
            if (indexMap.containsValue(num)) {
                result[0] = i;
                for (Integer key : indexMap.keySet()) {
                    if (indexMap.get(key) == num) {
                        result[1] = key;
                        break;
                    }
                }
            }
        }
        return result;
    }

}
