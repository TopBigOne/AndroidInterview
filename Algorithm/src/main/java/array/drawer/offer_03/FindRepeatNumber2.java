package array.drawer.offer_03;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/26 16:46
 * @Desc :
 * <p>
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/tong-de-si-xiang-by-liweiwei1419/
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/
 */
public class FindRepeatNumber2 extends Base {
    public static void main(String[] args) {
        FindRepeatNumber2 findRepeatNumber2 = new FindRepeatNumber2();
        // int[] nums = {2, 3, 1, 0, 2, 3, 5};

        int[] nums = {3, 4, 2, 0, 0, 1};
        int result = findRepeatNumber2.findRepeatNumber3(nums);
        System.err.println(" final result : " + result);
    }


    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～ n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * @param nums
     * @return
     */

    public int findRepeatNumber(int[] nums) {
        System.out.println(" " + Arrays.toString(nums));

        int index = 0;
        while (index < nums.length) {
            int currValue = nums[index];

            if (index == currValue) {
                index++;
                continue;
            }

            if (currValue == nums[currValue]) {
                return currValue;
            }

            System.out.println(" " + index + " swap " + currValue);
            System.out.println("    ");
            swap(nums, index, currValue);
            System.out.println("    " + Arrays.toString(nums));
        }

        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            int currValue = nums[index];
            if (index == currValue) {
                index++;
                continue;
            }
            if (nums[currValue] == currValue) {
                return currValue;
            }

            swap(nums, index, currValue);
        }
        return -1;

    }

    public int findRepeatNumber3(int[] nums) {
        int len = nums.length;
        int index = 0;
        while (index < len) {
            int currValue = nums[index];
            if (currValue == index) {
                index++;
                continue;
            }
            if (nums[currValue] == currValue) {
                return currValue;
            }
            swap(nums, index, currValue);
        }
        return -1;


    }

}
