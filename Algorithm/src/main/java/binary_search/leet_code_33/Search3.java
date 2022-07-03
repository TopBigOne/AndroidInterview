package binary_search.leet_code_33;

import binary_search.BastBinarySearch;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/2 22:26
 * @Desc :
 */
public class Search3 extends BastBinarySearch {
    public static void main(String[] args) {
        Search3 search3 = new Search3();
        int[] nums = {3, 4, 5, 6, 1, 2};
        int target = 2;
        int result = search3.search(nums, target);
        System.err.println("result : " + result);
    }

    public int search(int[] nums, int target) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return -1;
        }

        int peakIndex = findPeakIndex(nums);
        System.err.println("peakIndex : " + peakIndex);
        if (peakIndex >= 0 &&
                nums[0]<= nums[peakIndex] &&
                target <= nums[peakIndex]) {
            return binarySearch(nums, 0, peakIndex, target);
        }

        return binarySearch(nums, peakIndex + 1, len - 1, target);

    }

    private int findPeakIndex(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        // 纯单调递增的数组；
        if (nums[0] < nums[len - 1]) {
            return len - 1;
        }
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] > nums[mid + 1]) {
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


}
