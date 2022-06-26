package array.drawer.leet_code_442;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import array.drawer.Base;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/5/14 13:03
 * @Url : https://leetcode.cn/problems/find-all-duplicates-in-an-array/
 * @Level :    medium
 * @Desc :  数组中重复的数据:  给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 * <p>
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 * @Answer :
 */
public class FindDuplicate extends Base {
    /**
     * 找出数组中，出现2次的整数,利用hashmap 解答
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        // k: num
        // v: count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue() == 2) {
                result.add(integerIntegerEntry.getKey());
            }
        }
        return result;

    }

    /**
     * 牛逼的题解：https://leetcode.cn/problems/find-all-duplicates-in-an-array/solution/chou-ti-yuan-li-ji-yu-yi-huo-yun-suan-jiao-huan-li/
     * 抽屉原理
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        for (int i = 0; i < len; i++) {
            // int expectIndex = nums[i] - 1;
            while (true) {
                int expectIndex = nums[i] - 1;
                if (nums[i] == nums[expectIndex]) {
                    break;
                }

                System.out.println("    ");
                System.out.println("-------------");
                // 不是期望的位置，就做一下交换
                System.out.println("交换前：" + Arrays.toString(nums) + "当前下标 ：" + i);
                swap(nums, i, expectIndex);
                System.out.println("交换后：" + Arrays.toString(nums) + "当前下标 ：" + i);
                System.out.println("-------------");
                System.out.println("    ");

            }
        }

        for (int i = 0; i < len; i++) {
            if (i != nums[i] - 1) {
                res.add(nums[i]);
            }
        }

        return res;

    }

    public List<Integer> findDuplicates3(int[] nums) {

        List<Integer> result = new ArrayList<>();
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            return result;
        }

        for (int i = 0; i < len; i++) {
            while (true) {
                int expectIndex = nums[i] - 1;
                if (nums[i] == nums[expectIndex]) {
                    break;
                }
                swap(nums, i, expectIndex);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] - 1 != i) {
                result.add(nums[i]);
            }
        }

        return result;

    }


}
