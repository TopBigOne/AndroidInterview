package array.remove_duplicate_element.leet_code_283;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/5 16:00
 * @Desc :
 */
public class MoveZero3 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 1, 2};
        System.out.println("没有move的结果：" + Arrays.toString(nums));
        MoveZero3 moveZero = new MoveZero3();
        moveZero.moveZeroes(nums);
        System.out.println("Move以后的结果：" + Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int start = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[start] = num;
                start++;
            }
        }

        for (int i = start; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
