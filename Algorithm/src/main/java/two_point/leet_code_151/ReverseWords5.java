package two_point.leet_code_151;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/20 13:12
 * @Url :
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ReverseWords5 {
    public String reverseWords(String s) {
        StringBuilder sb = removeSpaces(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    public StringBuilder removeSpaces(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();

        while (start <= end) {
            char currChar = s.charAt(start);
            if (currChar != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(currChar);
            }
            start++;
        }
        return sb;
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;

        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int len = sb.length();
        while (start < len) {
            while (end < len && sb.charAt(end) != ' ') {
                end++;
            }

            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }

    }
}
