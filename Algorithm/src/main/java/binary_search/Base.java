package binary_search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/30 15:08
 * @Desc :
 */
public class Base {
    public static int[] generateArray(int... a) {
        List<Integer> res = new ArrayList<>();
        for (int i : a) {
            res.add(i);
        }

        return res.stream().mapToInt(v -> v).toArray();
    }

    public int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


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
}
