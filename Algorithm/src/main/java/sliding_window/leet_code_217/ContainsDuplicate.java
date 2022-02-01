package sliding_window.leet_code_217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/31 01:02
 * @Url :https://leetcode-cn.com/problems/contains-duplicate/
 * @Level :  easy
 * @Desc : 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/contains-duplicate-ii/solution/xiao-song-man-bu-hua-dong-chuang-kou-4da-l16m/
 */
public class ContainsDuplicate {
    /**
     * 最low的解法
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 1:先对数组做一下sort；
     * 2:然后 nums[i] ==num[i+1] ,注意，
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;

    }

    /**
     * 使用java-8 :
     * distinct: 返回一个流流的不同的元素组成
     * count: Returns the count of elements in this stream.
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }

}
