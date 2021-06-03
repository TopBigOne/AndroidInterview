package array.leet_code_315;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/3 17:14
 * @Url : https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 * @Level : easy medium hard
 * @Desc : 计算右侧小于当前元素的个数：
 * 给定一个整数数组 nums，按要求返回一个新数组counts。数组 counts 有该性质： counts[i] 的值是nums[i] 右侧小于nums[i] 的元素的数量。
 * @Counter :  4
 * @Answer :
 */
public class CountSmaller {

    public static void main(String[] args) {
        // [5,2,6,1]
        // [2,1,1,0]
        int[] nums = {5, 2, 6, 1};
        CountSmaller countSmaller = new CountSmaller();

        List<Integer> result = countSmaller.countSmaller(nums);

        System.out.println("result: " + result);


    }

    /**
     * 暴力解法，会超时
     *
     * @param nums data
     * @return result
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        System.out.println("|-------------------------------|");
        for (int i = 0; i < nums.length; i++) {
            int num = 0;
            for (int j = i + 1; j < nums.length; j++) {
                int left = nums[i];
                int right = nums[j];
                System.out.println("   left:" + left + ", right : " + right);
                System.out.println("   left:" + left);
                System.out.println("   right:" + right);
                System.out.println("|-------------------------------|");
                if (left > right) {
                    num++;
                }
            }
// /Volumes/Mac_aosp/aosp/packages/services/Mms
            // /Volumes/Mac_aosp/aosp/packages/apps/Messaging/src/android/support/v7/mms
            result.add(num);
        }
        return result;

    }
}
