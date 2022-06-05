package two_point.leet_code_151;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/21 11:38
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ReverseWords7 {
    public String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }


    char nullChar = ' ';

    public StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == nullChar) start++;
        while (s.charAt(end) == nullChar) end--;

        StringBuilder sb = new StringBuilder();

        while (start <= end) {
            char currChar = s.charAt(start);
            if (currChar != nullChar || sb.charAt(sb.length() - 1) != nullChar) {
                sb.append(currChar);
            }
            start++;
        }
        return sb;
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

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int len = sb.length();
        while (start < len) {
            while (end < len && sb.charAt(end) != nullChar) {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
