package sliding_window.leet_code_219;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/31 00:01
 * @Url :https://leetcode-cn.com/problems/contains-duplicate-ii/
 * @Level :  easy
 * @Desc :
 * @Counter : 3
 * @Answer :
 */
public class ContainsNearbyDuplicate3 {

    /**
     * 滑动窗口题目
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < length) {
            while (right < length && right - left <= k) {
                if (map.containsKey(nums[right]) && Math.abs(right - map.get(nums[right])) <= k) {
                    return true;
                }
                map.put(nums[right], right);
                right++;
            }
            left = right;
        }
        return false;
    }

}
