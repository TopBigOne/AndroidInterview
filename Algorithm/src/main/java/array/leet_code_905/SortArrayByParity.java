package array.leet_code_905;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  9/13/21 7:16 PM
 * @Desc :  leetcode  905 https://leetcode-cn.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {3, 6, 8, 13, 17, 32, 4};
        SortArrayByParity arrayByParity = new SortArrayByParity();
        int[] result = arrayByParity.sortArrayByParity(nums);
        System.out.println("result : " + Arrays.toString(result));
    }

    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 > nums[j] % 2) {
                swap(nums, i, j);
            }

            if (nums[i] % 2 == 0) {
                i++;
            }
            if (nums[j] % 2 == 1) {
                j--;
            }

        }
        return nums;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
