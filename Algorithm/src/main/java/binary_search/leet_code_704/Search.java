package binary_search.leet_code_704;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/5/31 21:40
 * @Url : https://leetcode-cn.com/problems/binary-search/
 * @Level : easy medium hard
 * @Desc :  二分查找
 * @Counter : 9
 * @Answer : https://leetcode-cn.com/problems/binary-search/solution/er-fen-cha-zhao-xiang-jie-by-labuladong/
 */
public class Search {
    public int search(int[] nums, int target) {
        int low = 0;
        // 1: 注意 数组是从 0 开始的；
        int high = nums.length - 1;
        while (low <= high) {
            // 2： >> 和 + ,优先级问题；
            int mid = low + (high - low) >> 1;
            int currValue = nums[mid];
            // 3-1： 恰巧相等；
            if (currValue == target) {
                return mid;
            } else if (currValue < target) {
                // 3-2：当前下标所对应的值，比target 要小，低位，要向右边走；
                low = mid + 1;
            } else {
                // 3-3： 当前小标所对应的值，比 target 要打，这时；高位，向左边走；
                high = mid - 1;
            }
        }
        // 4： 没有找到合适的值；
        return -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            int midValue = nums[mid];
            if (midValue == target) {
                return mid;
            }
            if (midValue < target) {
                left = mid + 1;
                continue;
            }
            if (midValue > target) {
                right = mid - 1;
            }
        }
        return -1;


    }

}
