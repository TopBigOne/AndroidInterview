package array.leet_code_283;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/27 22:24
 * @Url :https://leetcode-cn.com/problems/move-zeroes/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 1, 2};
        System.out.println("没有move的结果：" + Arrays.toString(nums));
        MoveZero moveZero = new MoveZero();
        moveZero.moveZeroes(nums);
        System.out.println("Move以后的结果：" + Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int l = 0;
        int len = nums.length;
        for (int r = 0; r < len; r++) {
            if (nums[r] != 0) {
                swap(nums, r, l);
                l++;
                System.out.println("每次移动以后的数组："+ Arrays.toString(nums));
            }
        }
    }

    public void moveZeros2(int[] nums) {
        int l = 0;
        int len = nums.length;
        for (int r = 0; r < len; r++) {
            if (nums[r] != 0) {
                swap(nums, r, l);
                l++;
            }
        }
    }

    public void  moveZeros3(int [] nums){
        int l = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(nums[1]!=0){
                swap(nums,i,l);
                l++;

            }
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
