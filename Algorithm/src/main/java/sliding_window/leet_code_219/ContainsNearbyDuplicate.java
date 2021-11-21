package sliding_window.leet_code_219;

import java.util.HashSet;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/20 21:23
 * @Url : https://leetcode-cn.com/problems/contains-duplicate-ii/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/contains-duplicate-ii/solution/hua-jie-suan-fa-219-cun-zai-zhong-fu-yuan-su-ii-by/
 */
public class ContainsNearbyDuplicate {
    /**
     * 1：维护一个hash表，里面始终最多包含k个元素，当出现重复值时，则说明在k距离内，存在重复元素；
     * 2：每次遍历一个元素则将其加入hash表中，如果hash表的大小小于k，则移除最前面的数字；
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int currValue = nums[i];
            if (set.contains(currValue)) {
                return true;
            }
            set.add(currValue);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int currValue = nums[i];
            if (set.contains(currValue)) {
                return true;
            }
            set.add(currValue);

            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;

    }

    public boolean containsNearbyDuplicate4(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int currValue = nums[i];
            if (set.contains(currValue)) {
                return true;
            }
            set.add(currValue);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;



    }
}
