package two_point.offer_58;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/5 14:41
 * @Desc :
 */
public class ReverseWord2 {
    public static void main(String[] args) {
        ReverseWord2 reverseWord = new ReverseWord2();
        String s = "the sky is blue";
        String result = reverseWord.reverseWords(s);
        System.err.println("result : " + result);
    }

    public String reverseWords(String s) {

        if (s == null || (s.length()) == 0) {
            return s;
        }
        if (s.equals(" ")) {
            return "";
        }
        // step 1
        StringBuilder sb = removeSpace(s);
        // step 2
        reverseString(sb, 0, sb.length() - 1);
        // step 3
        reverseSingleWord(sb);
        return sb.toString();

    }

    private StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end && s.charAt(start) == ' ') {
            start++;
        }

        while (end > 0 && s.charAt(end) == ' ') {
            end--;
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (start <= end) {
            if (s.charAt(start) != ' ' || stringBuilder.charAt(stringBuilder.length() - 1) != ' ') {
                stringBuilder.append(s.charAt(start));
            }
            start++;
        }


        return stringBuilder;
    }

    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char c = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, c);
            start++;
            end--;
        }

    }

    private void reverseSingleWord(StringBuilder sb) {
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
