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
        int right = nums.length - 1;
        // 1 2 2  4 5 6 ;
        while (left <= right) {
            int mid = (left + right) >>> 1;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;

            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        if (left > nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 寻找左边界的时候，右指针是一步步(-1)的向左递减的
     *
     * @param nums
     * @param target
     * @return
     */
    public int leftBound2(int[] nums, int target) {
        int left = 0;
        // 注意不 -1；
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }

        if (left > nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 2 3 4  5 6  6  6 6 7 8 9;
     * 处理右边界的时候，左指针是一步步(+1)向右推进的；
     *
     * @param nums
     * @param target
     * @return
     */
    public int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;


    }
}
