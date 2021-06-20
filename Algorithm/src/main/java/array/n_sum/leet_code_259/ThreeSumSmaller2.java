package array.n_sum.leet_code_259;

import java.nio.IntBuffer;
import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  6/20/21 12:56 AM
 * @Desc :
 */
public class ThreeSumSmaller2 {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length - 1; i++) {
            int remainder = target - nums[i];
            sum += twoSumSmaller(nums, i + 1, remainder);
        }
        return sum;
    }

    private int twoSumSmaller(int[] nums, int left, int remainder) {
        int sum = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < remainder) {
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }

    public int threeSumSmaller2(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int remainder = target - nums[i];
            sum+= twoSumSmaller2(nums,i+1,remainder);
        }
        return  sum;
    }
    public int twoSumSmaller2(int [] nums,int left,int remainder){
        int sum = 0;
        int right = nums.length-1;
        while (left<right){
            if(nums[left]+nums[right]<remainder){
                sum += right-left;
                left++;
            }
            else {
                right--;
            }
        }

        return sum;

    }


}
