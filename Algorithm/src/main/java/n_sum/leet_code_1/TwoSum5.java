package n_sum.leet_code_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/26 22:20
 * @Desc :
 */
public class TwoSum5 {
    public static void main(String[] args) {
        TwoSum5 twoSum = new TwoSum5();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum.twoSum(nums, target);
        System.err.println("result : " + Arrays.toString(result));

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{i, map.get(temp)};
            }
            map.put(nums[i], i);

        }
        return new int[]{-1, -1};


    }
}
