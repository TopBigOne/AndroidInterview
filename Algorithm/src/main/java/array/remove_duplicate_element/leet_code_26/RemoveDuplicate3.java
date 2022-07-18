package array.remove_duplicate_element.leet_code_26;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/18 10:33
 * @Desc : 26. 删除有序数组中的重复项: https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 *
 */
public class RemoveDuplicate3 {
    public int removeDuplicates(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }
        int start = 1;
        for (int i = 1; i < len; i++) {
            // 当前值，不等于前面的值
            if (nums[i] != nums[start - 1]) {
                nums[start] = nums[i];
                start++;
            }
        }
        return start;

    }
}
