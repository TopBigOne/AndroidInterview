package array.leet_code_189;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/11 23:11
 * @Url :https://leetcode-cn.com/problems/rotate-array/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/rotate-array/solution/shu-zu-fan-zhuan-xuan-zhuan-shu-zu-by-de-5937/
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Rotate rotate = new Rotate();
        rotate.rotate2(nums, k);
        System.out.println("result: " + Arrays.toString(nums));


    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        System.out.println("K : " + k);
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        k %=length;
        reverse(nums,0,length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,length-1);


    }
}
