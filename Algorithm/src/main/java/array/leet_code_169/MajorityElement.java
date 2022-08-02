package array.leet_code_169;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  6/27/21 11:49 PM
 * @Desc : leetcode 169 ： 多数元素：字节：8 次：  https://leetcode-cn.com/problems/majority-element/
 * <p>
 * 题解：https://leetcode-cn.com/problems/majority-element/solution/3chong-fang-fa-by-gfu-2/
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] raw = {2, 2, 1, 1, 1, 2, 2};
        MajorityElement majorityElement = new MajorityElement();
        majorityElement.majorityElement2(raw);

    }

    public int majorityElement(int[] nums) {
        int limit = nums.length >> 1;
        HashMap<Integer, Integer> map = new HashMap<>(limit);
        for (int num : nums){
            map.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > limit)
                return entry.getKey();
        }

        return -1;
    }

    public int majorityElement2(int[] nums) {
        int limit = nums.length >> 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println("map : " + map);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > limit) {
                return entry.getKey();
            }

        }

        return -1;


    }


}
