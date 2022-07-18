package array.remove_duplicate_element.leet_code_80;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/25 19:23
 * @Desc :
 * <p>
 * https://leetcode.cn/problems/two-sum/solution/suo-you-ti-jie-de-mu-lu-lian-jie-si-wei-ecnoo/
 */
public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return length;
        }
        // 数组前两个数，必然保留
        int fast = 2;
        int slow = 2;
        while (fast < length) {
            System.out.println("DYNAMIC CHANGE : " + Arrays.toString(nums));
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;

        }

        System.out.println("我期望的数组：" + Arrays.toString(nums));
        System.out.println("我期望的数组的长度：" +nums.length);

        // From index 0 to slow-1, 每个元素都不相等；
        return slow;

    }
}
