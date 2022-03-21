package n_sum.leet_code_1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/3/18 11:02
 * @Url : 两数之和：https://leetcode-cn.com/problems/two-sum/
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class TwoSum4 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                result[0] = map.get(temp);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;


    }
}
