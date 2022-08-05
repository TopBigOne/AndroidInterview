package array.remove_duplicate_element.leet_code_27;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/18 10:23
 * @Desc : 27: 移除数组中的重复元素 : https://leetcode.cn/problems/remove-element/
 */
public class RemoveElement2 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.err.println("原始数组 : " + Arrays.toString(nums));
        RemoveElement2 removeElement = new RemoveElement2();
        int result = removeElement.removeElement(nums, val);
        System.err.println("移除重复元素的数组 : " + Arrays.toString(nums));
        System.err.println("result : " + result);
    }

    public int removeElement(int[] nums, int val) {
        int start = 0;
        for (int num : nums) {
            if (num != val) {
                nums[start] = num;
                start++;
            }
        }
        return start;

    }

    public int removeElement2(int[] nums, int val) {

        int start = 0;
        for (int num : nums) {
            if (num != val) {
                nums[start] = num;
                start++;
            }
        }

        return start;


    }
}
