package math.appear_n_time.leet_code_136;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/23 21:31
 * @Url : 136. 只出现一次的数字 https://leetcode-cn.com/problems/single-number/solution/
 * @Level :  easy
 * @Desc :
 * @Counter : 12
 * @Answer : https://leetcode-cn.com/problems/single-number/solution/xue-suan-fa-jie-guo-xiang-dui-yu-guo-cheng-bu-na-y/
 */
public class SingleNumber {
    /**
     * 默认的解答方式
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.

    }

    /**
     * 异或
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;


    }

    public int singleNumber3(int[] nums) {
        int res = nums[0];
        int len = nums.length;
        if (len <= 1) {
            return res;
        }
        for (int i = 1; i < len; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public int singleNumber4(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        if(len<=1){
            return res;
        }
        for (int i = 1; i < len; i++) {
            res = res^nums[i];
        }

        return res;

    }
}
