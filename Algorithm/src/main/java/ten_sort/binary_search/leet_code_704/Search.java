package ten_sort.binary_search.leet_code_704;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/5/31 21:40
 * @Url : https://leetcode-cn.com/problems/binary-search/
 * @Level : easy medium hard
 * @Desc :  二分查找
 * @Counter : 9
 * @Answer :
 */
public class Search {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (target>nums[mid]) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return -1;

    }

}
