package array.drawer.leet_code_41;

import array.drawer.Base;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/15 21:26
 * @Url : 41. 缺失的第一个正数 https://leetcode.cn/problems/first-missing-positive/solution/
 * @Level :    hard
 * @Desc :
 * @Counter :
 * @Answer :
 * <p>
 * https://www.youtube.com/watch?v=jfb72FfxWKU
 * <p>
 * nums[nums[i]-1]!=nums[i]
 * <p>
 * 题解：https://leetcode.cn/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
 */
public class FirstMissingPositive2 extends Base {

    public static void main(String[] args) {
        FirstMissingPositive2 firstMissingPositive = new FirstMissingPositive2();
        int[] nums = {7, 8, 9, 11, 12};
        int result = firstMissingPositive.firstMissingPositive2(nums);
        System.err.println("result : " + result);
    }

    public int firstMissingPositive(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);

            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }

        }

        return len + 1;


    }

    public int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < len; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }

        return len + 1;
    }

    public int firstMissingPositive3(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (true) {
                int currValue = nums[i];

                if (!(currValue > 0 && currValue <= len && currValue != nums[currValue - 1])) break;
                swap(nums, i, currValue - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public int firstMissingPositive4(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (true) {
                int currValue = nums[i];
                if (!(currValue > 0 && currValue <= len && currValue != nums[currValue - 1])) break;
                swap(nums, i, currValue - 1);
            }

        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public int firstMissingPositive5(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {

            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;


    }


}
