package two_point.leet_code_151;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/3/25 13:29
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ReverseWords8 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        String s = "the sky is blue";
        ReverseWords8 reverseWords = new ReverseWords8();
        String result = reverseWords.reverseWords(s);
        System.out.println("result : " + result);
    }

    public String reverseWords(String s) {
        // step 1
        StringBuilder sb = removeSpace(s);
        System.err.println("result  step 1: " + sb);

        reverseString(sb, 0, sb.length() - 1);
        System.err.println("result  step 2: " + sb);

        reverseEachWord(sb);
        System.err.println("result  step 3: " + sb);
        return sb.toString();

    }

    private StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;
        }

        StringBuilder sb = new StringBuilder();

        while (s.charAt(end) == ' ') {
            end--;
        }

        // 移除中间多余的空格
        while (start <= end) {
            char currChar = s.charAt(start);
            if (currChar != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(currChar);
            }
            start++;
        }
        return sb;
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int length = sb.length();
        while (start < length) {
            while (end < length && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;

        }
    }

    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);

            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);

            start++;
            end--;
        }
    }


}
