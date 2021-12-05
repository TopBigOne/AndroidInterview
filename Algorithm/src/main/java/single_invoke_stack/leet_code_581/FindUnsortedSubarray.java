package single_invoke_stack.leet_code_581;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/20 21:22
 * @Url :  https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * @Level :    medium
 * @Desc :  给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * @Counter :  5
 * @Answer : https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/gong-shui-san-xie-yi-ti-shuang-jie-shuan-e1le/
 */
public class FindUnsortedSubarray {
    /**
     *双指针+排序
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();

        Arrays.sort(arr);
        int i = 0;
        int j = n - 1;
        while (i <= j && nums[i] == arr[i]) {
            i++;
        }
        while (i <= j && nums[j] == arr[j]) {
            j--;
        }

        return j - i + 1;
    }

    public int findUnsortedSubarray2(int [] nums){
        int n = nums.length;
        int [] arr = nums.clone();
        Arrays.sort(arr);

        int i  =0;
        int j = n-1;
        while (i<=j&&nums[i]==arr[i]){
            i++;
        }
        while (i<=j&&nums[j]==arr[j]){
            j--;
        }

        return  j-i+1;

    }
}
