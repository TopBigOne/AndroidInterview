package array.n_sum.leet_code_1;

/**
 * @author : dev
 * @version :
 * @Date :  5/1/21 11:25 PM
 * @Desc : 假设数组是一个有序的；
 * 考虑一下，使用双指针
 */
public class TwoSum3 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (target > sum) {
                right--;
            } else if (target < sum) {
                left++;
            }

        }

        return new int[]{-1, -1};

    }
}
