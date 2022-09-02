package array.drawer.leet_code_442;


import java.util.ArrayList;
import java.util.List;

import array.drawer.Base;

/**
 * @author : dev
 * @version :
 * @Date :  2022/9/1 23:04
 * @Desc :
 */
public class FindDuplicate2 extends Base {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindDuplicate2 findDuplicate = new FindDuplicate2();
        List<Integer> result = findDuplicate.findDuplicates(nums);
        System.err.println("result : " + result);
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        // [1. ......n]
        //  [0......n-1]
        // step 1: sort it;
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

        for (int i = 0; i < len; i++) {
            if(i !=nums[i]-1){
                result.add(nums[i]);
            }

        }


        return result;

    }


}
