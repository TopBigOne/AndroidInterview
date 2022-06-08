package n_sum.offer_57;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/4 18:10
 * @Desc :
 */
public class TwoSum {
    /**
     * 双指针的技巧
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            int midValue = nums[low] + nums[high];
            if (midValue == target) {
                return new int[]{nums[low], nums[high]};
            }
            if (midValue < target) {
                low = low + 1;
            } else {
                high = high - 1;
            }
        }
        return new int[]{0, 0};
    }
}
