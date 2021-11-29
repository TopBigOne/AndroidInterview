package array.leet_code_66;

import java.util.Arrays;
import java.util.DuplicateFormatFlagsException;

/**
 * @author : dev
 * @version :
 * @Date :  11/23/21 7:48 PM
 * @Desc :  https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/
 * <p>
 * 老铁，你要理解题意；
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] nums = {3, 5, 8};
        PlusOne plusOne = new PlusOne();
        int[] result = plusOne.plusOne3(nums);
        System.out.println("result :" + Arrays.toString(result));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        // >9;
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne3(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        digits = new int[length + 1];
        digits[0] = 1;
        return digits;


    }


}
