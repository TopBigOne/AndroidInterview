package array.remove_duplicate_element.leet_code_26;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/5 16:09
 * @Desc :
 */
public class RemoveDuplicate4 {
    public int removeDuplicates(int[] nums) {
        int start = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[start] = nums[i];
                start++;
            }
        }

        return start;
    }

    public int removeDuplicates2(int[] nums) {
        int start = 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[start] = nums[i];
                start++;
            }
        }
        return start;
    }
}
