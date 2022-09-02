package array.drawer.leet_code_442;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import array.drawer.Base;

/**
 * @author : dev
 * @version :
 * @Date :  2022/9/2 11:07
 * @Desc :
 */
public class FindDuplicate3 extends Base {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindDuplicate3 findDuplicate = new FindDuplicate3();
        List<Integer> result = findDuplicate.findDuplicates(nums);
        System.err.println("result : " + result);
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (true) {
                int expectIndex = nums[i] - 1;
                if (nums[i] == nums[expectIndex]) {
                    break;
                }
                swap(nums, i, expectIndex);
            }
        }
        System.err.println(Arrays.toString(nums));
        for (int i = 0; i < len; i++) {
            if (nums[i] - 1 != i) {
                result.add(nums[i]);
            }
        }
        return result;
    }

}
