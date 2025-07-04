package array.leet_code_189;

import java.util.Arrays;

import array.BaseFun;

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
public class Rotate extends BaseFun {
    public static void main(String[] args) {
        int[] nums = generateArray(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int k = 100;
        Rotate rotate = new Rotate();
        rotate.rotate(nums, k);
        System.err.println("result: " + Arrays.toString(nums));

    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        System.out.println("K : " + k);
        reverse(nums, 0, length - 1);
        System.out.println("step 1 : " + Arrays.toString(nums));

        reverse(nums, 0, k - 1);
        System.out.println("step 2 : " + Arrays.toString(nums));

        reverse(nums, k, length - 1);
        System.out.println("step 3 : " + Arrays.toString(nums));
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
        k %= length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    public void rotate3(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public void rotate4(int[] nums, int k) {
        int len = nums.length;
        k%=len;
        reverse(nums,0,len-1);
        reverse(nums,0, k-1);
        reverse(nums,k, len-1);
        
    }


}
