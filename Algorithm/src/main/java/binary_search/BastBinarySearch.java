package binary_search;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/2 22:30
 * @Desc :
 */
public class BastBinarySearch {

    public int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
                continue;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 寻找左边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int leftBound(int[] nums, int target) {
        int left = 0;
        // 注意不 -1；
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }
}
