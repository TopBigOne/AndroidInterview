package string.leet_code_151;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 14:25
 * @Desc :
 */
public class ReverseWords13 {
    public static void main(String[] args) {
        String rawStr = "    I    love  you ";
        rawStr = "the sky is blue";
        ReverseWords13 reverse = new ReverseWords13();
        String result = reverse.reverseWords(rawStr);
        System.out.println("result: " + result);
    }

    public String reverseWords(String s) {

        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        s = s.trim();
        int start = 0;
        int end = s.length() - 1;
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
        int len = sb.length() ;
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
