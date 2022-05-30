package array.remove_element.leet_code_80;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/25 20:06
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        testOne();
    }

    private static void testOne() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println("原始数组 : " + Arrays.toString(nums));
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        int newLength = removeDuplicate.removeDuplicates(nums);
        System.out.println("newLength : " + newLength);

    }
}
