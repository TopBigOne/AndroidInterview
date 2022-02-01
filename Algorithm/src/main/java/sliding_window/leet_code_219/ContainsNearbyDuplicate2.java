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
 * @Counter :
 * @Answer :
 */
public class ContainsNearbyDuplicate2 {

    /**
     * 滑动窗口题目
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // key   : num[i]
        // value : index
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = nums.length;
        while (right < length) {
            // 扩大窗口
            while (right < length && right - left <= k) {
                if (map.containsKey(nums[right]) && right - map.get(nums[right]) <= k) {
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
