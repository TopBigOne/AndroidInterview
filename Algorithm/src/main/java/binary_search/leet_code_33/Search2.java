package binary_search.leet_code_33;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/1 19:31
 * @Desc :
 */
public class Search2 {
    public static void main(String[] args) {
        Search2 search = new Search2();
        int[] nums = {3, 4, 5, 6, 1, 2};
        int target = 2;
        int result = search.search(nums, target);
        System.err.println("result : " + result);
    }

    /**
     * 一姐
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return -1;
        }
        int peakIndex = findPeakIndex(nums);

        System.err.println("peakIndex: " + peakIndex);

        // 在左边找
        if (peakIndex >= 0 &&
                target >= nums[0] &&
                target <= nums[peakIndex]) {
            return binarySearch(nums, 0, peakIndex, target);
        }
        // 在右边找
        return binarySearch(nums, peakIndex + 1, len - 1, target);
    }

    private int findPeakIndex(int[] nums) {
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
            // case 1: 返回相应index
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // case 2:
            if (nums[l] <= nums[mid]) {
                l = mid + 1;
                continue;
            }

            // case 3:
            if (nums[l] > nums[mid]) {
                r = mid - 1;
            }

        }

        return 0;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
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
