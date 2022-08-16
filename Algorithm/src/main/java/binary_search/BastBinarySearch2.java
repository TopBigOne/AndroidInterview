package binary_search;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/16 15:07
 * @Desc :
 */
public class BastBinarySearch2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4, 5};
        BastBinarySearch2 bastBinarySearch = new BastBinarySearch2();
        int leftIndex = bastBinarySearch.leftBound(nums, 2);
        int rightIndex = bastBinarySearch.rightBound(nums, 2);
        System.err.println("leftIndex  : " + leftIndex);
        System.err.println("rightIndex : " + rightIndex);
    }

    public int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >>> 1;
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
