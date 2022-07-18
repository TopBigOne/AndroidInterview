package array.remove_duplicate_element.leet_code_26;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/25 18:06
 * @Desc :leetcode 26 删除有序数组的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/
 */
public class RemoveDuplicate2 {
    public int removeDuplicates(int[] nums) {
        // 指向有效数组的最后一位
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 表示不重复，将i位置的值，添加到index的下一个位置
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
