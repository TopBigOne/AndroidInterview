package dynamic_programming.leet_code_53;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * @author : dev
 * @version :
 * @Date :  1/25/21 11:41 PM
 * @Desc : https://leetcode-cn.com/problems/maximum-subarray/
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 可以用贪心算法和 dp；
 * 贪心：若当前指针元素之前的和 小于 0 ，则丢弃当前元素之前的数列；
 * <p>
 * <p>
 * 同时，也验证了一下 java8 新特性
 */
public class MaximumSubArray {
    /**
     * 顺便使用 java8 新特性
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int length = nums.length;
        int[] f = new int[length];
        //初始化边界
        f[0] = nums[0];
        for (int i = 1; i < length; i++) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
        }
        int asInt = Arrays.stream(f).max().getAsInt();
        System.out.println("asInt：" + asInt);
        return asInt;
    }

    public int maxSubArray2(int[] nums) {
        int length = nums.length;
        int[] f = new int[length];
        int result = nums[0];
        int sum = nums[0];
        for (int i = 1; i < length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }


    /**
     * 最大子序列
     *
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        int length = nums.length;
        int result = nums[0];
        int sum = nums[0];
        for (int i = 1; i < length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }

    public int maxSubArray4(int[] nums) {
        int length = nums.length;
        int result =  nums[0];
        int sum = nums[0];
        for (int i = 1; i < length; i++) {
            sum = Math.max(nums[i] + sum, nums[i]);
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }

    public int maxSubArray5(int[] nums) {
        int length = nums.length;
        int sum = nums[0];
        int result =  nums[0];

        for (int i = 1; i < length; i++) {
            sum = Math.max(nums[i] + sum, nums[i]);
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }


    public int maxSubArray6(int[] nums) {
        int length = nums.length;
        int sum = nums[0];
        int result =  nums[0];
        for (int i = 1; i < length; i++) {
            sum = Math.max(nums[i] + sum, nums[i]);
            if (sum > result) {
                result = sum;
            }

        }
        return result;
    }

    public int maxSubArray7(int[] nums) {
        int length = nums.length;
        int sum = nums[0];
        int result =  nums[0];
        for (int i = 1; i < length; i++) {
            sum = Math.max(nums[i] + sum, nums[i]);
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }

    public int maxSubArray8(int[] nums) {
        int length = nums.length;
        int sum = nums[0];
        int result =  nums[0];
        for (int i = 1; i < length; i++) {
            sum = Math.max(nums[i] + sum, nums[i]);
            if (sum > result) {
                result = sum;
            }
        }

        return result;
    }

    public int maxSubArray9(int [] nums){
        int length = nums.length;
        int sum = nums[0];
        int result = nums[0];
        for (int i = 1; i < length; i++) {
            sum = Math.max(nums[i]+sum,nums[i]);
            if (sum>result) {
                result = sum;
            }

        }
       return result;
    }


}
