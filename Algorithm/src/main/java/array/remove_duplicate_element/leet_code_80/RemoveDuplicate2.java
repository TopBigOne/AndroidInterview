package array.remove_duplicate_element.leet_code_80;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/5 16:30
 * @Desc :
 */
public class RemoveDuplicate2 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return length;
        }

        int fast = 2;
        int slow = 2;
        while (fast < length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;

    }

    public int removeDuplicates2(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }

        int fast = 2;
        int slow = 2;
        while (fast < length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;

            }
            fast++;
        }
        return slow;


    }
}
