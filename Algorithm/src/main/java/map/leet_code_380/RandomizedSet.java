package map.leet_code_380;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/10/23 21:11
 * @Url :
 * @Level :  easy  medium hard
 * @Desc : 380. O(1) 时间插入、删除和获取随机元素 ：https://leetcode.cn/problems/insert-delete-getrandom-o1/description/?favorite=2ckc81c&orderBy=most_votes
 * @Counter :
 * @Answer : https://leetcode.cn/problems/insert-delete-getrandom-o1/solutions/1416888/by-ac_oier-tpex/?orderBy=most_votes
 */
public class RandomizedSet {
    static int[] nums = new int[200010];
    Random random = new Random();
    Map<Integer, Integer> map = new HashMap<>();
    int idx = -1;

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        nums[++idx] = val;
        map.put(val, idx);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int loc = map.remove(val);
        if (loc != idx) map.put(nums[idx], loc);
        nums[loc] = nums[idx--];
        return true;
    }

    public int getRandom() {
        return nums[random.nextInt(idx + 1)];
    }


}
