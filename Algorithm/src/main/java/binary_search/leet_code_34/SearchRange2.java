package binary_search.leet_code_34;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/28 20:13
 * @Desc :
 */
public class SearchRange2 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        SearchRange2 searchRange2 = new SearchRange2();
        int[] result = searchRange2.searchRange(nums, target);
        System.err.println(Arrays.toString(result));
    }

    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int second = findSecond(nums, target);
        return new int[]{first, second};
    }

    private int findFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int midValue = nums[mid];
            if (midValue >= target) {
                // 往后退一大步...
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // right
    private int findSecond(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            int midValue = nums[mid];

            if (midValue <= target) {
                // 大步向右边移动
                l = mid;
            } else {
                // 不断的往后移动
                r = mid - 1;
            }
        }
        return r;
    }
}
