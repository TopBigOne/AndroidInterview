package n_sum.leet_code_454;

import java.util.HashMap;
import java.util.Map;

import sun.security.provider.Sun;

/**
 * @author : dev
 * @version :
 * @Date :  12/27/21 8:37 PM
 * @Desc : 四数相加
 * <p>
 * https://leetcode-cn.com/problems/4sum-ii/
 * <p>
 * 题解：https://leetcode-cn.com/problems/4sum-ii/solution/chao-ji-rong-yi-li-jie-de-fang-fa-si-shu-xiang-jia/
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int k : nums1) {
            for (int i : nums2) {
                int sum12 = k + i;
                if (map.containsKey(sum12)) {
                    map.put(sum12, map.get(sum12) + 1);
                } else {
                    map.put(sum12, 1);
                }
            }
        }
        for (int k : nums3) {
            for (int i : nums4) {
                int sum34 = -(k + i);
                if (map.containsKey(sum34)) {
                    res += map.get(sum34);
                }

            }
        }
        return res;
    }
}
