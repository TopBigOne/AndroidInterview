package binary_search.leet_code_33;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/3 14:11
 * @Desc :
 */
public class Search6 {

    /**
     * 一姐
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = 0;
        if (nums == null ||(len = nums.length) == 0) {
            return -1;
        }
        int peakIndex = findPeakIndex(nums);
        if (peakIndex >= 0 &&
                target >= nums[0] &&
                target <= nums[peakIndex]) {
            return binarySearch(nums, 0, peakIndex, target);
        }

        return binarySearch(nums, peakIndex + 1, len - 1, target);


    }

    public int findPeakIndex(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        if (nums[0] < nums[len - 1]) {
            return len - 1;
        }

        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int midValue = nums[mid];

            if (midValue > nums[mid + 1]) {
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                l = mid + 1;
                continue;
            }
            if (nums[l] > nums[mid]) {
                r = mid - 1;
            }
        }

        return 0;
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int midValue = nums[mid];
            if (target == midValue) {
                return mid;
            }
            if (midValue < target) {
                l = mid + 1;
                continue;
            }
            if (midValue > target) {
                r = mid - 1;
            }
        }

        return -1;
    }



}
