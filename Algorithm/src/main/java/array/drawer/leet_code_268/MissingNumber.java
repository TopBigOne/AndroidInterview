package array.drawer.leet_code_268;

import array.drawer.Base;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/26 16:49
 * @Desc :  268. 丢失的数字  https://leetcode.cn/problems/missing-number/
 * https://leetcode.cn/problems/missing-number/solution/
 */
public class MissingNumber extends Base {
    public static void main(String[] args) {
        // int[] nums = {3, 0, 1};
        //   int[] nums = {0, 1};
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        MissingNumber missingNumber = new MissingNumber();
        int result = missingNumber.missingNumber(nums);
        System.err.println("result : " + result);

    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 防止越界
            if (nums[i] != i && nums[i] < n) {
                swap(nums, nums[i], i--);
                // System.err.println("step swap : " + Arrays.toString(nums));
            }
        }

        //  System.err.println("after swap : " + Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return n;

    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            if (nums[i] != i && nums[i] < n) {
                swap(nums, nums[i], i--);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    public int missingNumber3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i && nums[i] < n) {
                swap(nums, nums[i], i--);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return n;


    }


}
