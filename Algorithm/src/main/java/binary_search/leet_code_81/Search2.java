package binary_search.leet_code_81;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import binary_search.Base;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/30 18:57
 * @Desc :
 */
public class Search2 extends Base {
    public static void main(String[] args) {
        int[] nums = generateArray(2, 5, 6, 0, 0, 1, 2);
        Search2 search = new Search2();
        boolean result = search.search1(nums, 0);
        System.err.println("result : " + result);
    }

    public boolean search1(int[] nums, int target) {
        List<Integer> res = Arrays.stream(nums).boxed().collect(Collectors.toList());
        while (res.size() > 1 && res.get(res.size() - 1) == res.get(0)) {
            res.remove(res.size() - 1);
        }
        nums = res.stream().mapToInt(v -> v).toArray();
        System.err.println("去掉尾部与头部相等以后的数组: " + Arrays.toString(nums));

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            int midValue = nums[mid];
            if (midValue == target) {
                return true;
            }
            if (midValue >= nums[0] == target >= nums[0]) {
                if (midValue < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (target >= nums[0]) {
                right = mid - 1;
            } else if (target < nums[0]) {
                left = mid + 1;
            }
        }

        if (left == right && nums[left] == target) {
            return true;
        }
        return false;

    }
}
