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
}
