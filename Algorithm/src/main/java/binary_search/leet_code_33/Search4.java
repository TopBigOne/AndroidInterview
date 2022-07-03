package binary_search.leet_code_33;

import binary_search.BastBinarySearch;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/2 23:19
 * @Desc :
 */
public class Search4 extends BastBinarySearch {
    public static void main(String[] args) {
        // [4,5,6,7,0,1,2]
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        Search4 search = new Search4();
        int result = search.search(nums, target);
        System.out.println("result : "+result);
    }

    public int search(int[] nums, int target) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return -1;
        }
        int peakIndex = findPeakIndex(nums);
        System.err.println("peakIndex : " + peakIndex);
        System.out.println();
        if (peakIndex >= 0 &&

                target >= nums[0] &&
                target <= nums[peakIndex]) {
            return binarySearch(nums, 0, peakIndex, target);
        }

        return binarySearch(nums, peakIndex + 1, len - 1, target);
    }

    private int findPeakIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] < nums[nums.length - 1]) {
            return nums.length - 1;
        }
        int l = 0;
        int r = nums.length - 1;
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
