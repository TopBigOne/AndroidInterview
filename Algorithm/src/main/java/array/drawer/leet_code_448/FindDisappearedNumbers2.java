package array.drawer.leet_code_448;

import array.drawer.Base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/5/14 14:07
 * @Url :
 * @Level :  easy  medium hard
 * @Desc : 抽屉原理： https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/solution/tong-pai-xu-ji-yu-yi-huo-yun-suan-jiao-huan-liang-/
 * @Counter :
 * @Answer :
 */
public class FindDisappearedNumbers2 extends Base {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();
        int len;
        if (nums == null || (len = (nums.length)) == 0) {
            return result;
        }

        // 按照抽屉原理，index 处，放的值应该是index+1
        for (int i = 0; i < len; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < len; i++) {
            // (i+1) 就是没有出现的数据
            int expect = i + 1;
            if (nums[i] != expect) {
                result.add(expect);
            }
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int len;
        List<Integer> result = new ArrayList<>();
        if (nums == null || (len = nums.length) == 0) {
            return result;
        }

        for (int i = 0; i < len; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            int expect = i + 1;
            if (nums[i] != expect) {
                result.add(expect);
            }
        }

        return result;
    }
}
