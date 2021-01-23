package ten_sort.search;

/**
 * @author : dev
 * @version :
 * @Date :  1/21/21 6:11 PM
 * @Desc : 二分法右侧边界 搜索；
 * <p>
 * 比如说给你有序数组 nums = [1,2,2,2,3] ，
 */
public class RightBinarySearch {

    public static void main(String[] args) {
        RightBinarySearch rightBinarySearch = new RightBinarySearch();
        int[] nums = {1, 2, 2, 2, 3, 5, 5, 55};

        int result = rightBinarySearch.rightBound2(nums, 5);
        System.out.println("result : " + result);

    }

    public int rightBound(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;

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


    /**
     * 二 分法右测边界
     * @param nums
     * @param target
     * @return
     */
    public int rightBound2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;

            }
        }
        if (right < 1 || nums[right] != target) {
            return -1;
        }
        return right;
    }

}
