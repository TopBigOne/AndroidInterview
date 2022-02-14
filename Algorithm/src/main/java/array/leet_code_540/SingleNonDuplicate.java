package array.leet_code_540;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/14 16:41
 * @Url : https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 * @Level :    medium
 * @Desc : 有序数组里的单一元素
 * @Counter :
 * @Answer :
 */
public class SingleNonDuplicate {
    /**
     *
     * @param nums  [1,1,2,3,3,4,4,8,8]
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int length = nums.length;
        int left = 0, right = length - 1;

        while (left < right) {
            int mid = left + right >> 1;
            if (mid % 2 == 0) {
                if (mid + 1 < length && nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }

            } else {
                if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[right];
    }
}
