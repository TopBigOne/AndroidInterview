package array;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  6/27/21 11:31 PM
 * @Desc :
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int result = reverseInteger.reverseInteger(600);
        System.out.println("result : " + result);
    }

    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public int reverseInteger(int number) {
        if (number < 99) {
            return -1;
        }
        char[] chars = String.valueOf(number).toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        char[] c;
        if (chars[0] == '0' && chars[1] != '0') {
            c = Arrays.copyOfRange(chars, 1, chars.length);
        } else if (chars[0] == '0' && chars[1] == '0') {
            c = Arrays.copyOfRange(chars, 2, chars.length);
        } else {
            return Integer.parseInt(String.valueOf(chars));
        }

        return Integer.parseInt(String.valueOf(c));
    }


}
