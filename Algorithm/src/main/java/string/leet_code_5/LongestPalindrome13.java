package string.leet_code_5;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/6 15:21
 * @Desc :
 */
public class LongestPalindrome13 {

    public static void main(String[] args) {
        String s = "cbbd";
        LongestPalindrome13 longestPalindrome = new LongestPalindrome13();
        String result = longestPalindrome.longestPalindrome(s);
        System.err.println("result : " + result);

    }

    /**
     * @param s s = "babad"
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        // 0: start index
        // 1: len
        int[] max = new int[2];
        for (int i = 0; i < len; i++) {
            int[] old = centerSpread(s, i, i);
            int[] even = centerSpread(s, i, i + 1);
            int[] temp = even[1] > old[1] ? even : old;
            System.err.println("old  : " + Arrays.toString(old));
            System.err.println("even : " + Arrays.toString(even));
            System.err.println("temp : " + Arrays.toString(temp));
            System.err.println("-----------------------");
            if (temp[1] > max[1]) {
                max = temp;
            }
        }
        System.err.println("finally max : " + Arrays.toString(max));
        return s.substring(max[0], max[0] + max[1]);
    }

    private int[] centerSpread(String s, int i, int j) {
        int len = s.length();
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
                continue;
            }
            break;
        }


        System.err.println("centerSpread : " + j);
        return new int[]{i + 1, j - i - 1};
    }



}
