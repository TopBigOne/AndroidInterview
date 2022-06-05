package two_point.offer_58;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/25 15:00
 * @Desc :
 * k = 2
 * ab cdefg
 * cdefg ab
 * -----
 * k = 6
 * lrloseumgh
 * umghlrlose
 */
public class ReverseWord {

    public static void main(String[] args) {
        ReverseWord reverseWord = new ReverseWord();
        String s = "  hello world!  ";
        String result = reverseWord.reverseWords(s);
        System.out.println("result : " + result);
    }


    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // ""
        if (s.equals(" ")) {
            return "";
        }

        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        // step 3:
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

        StringBuilder sb = new StringBuilder();
        while (start <= end) {

            if (s.charAt(start) != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(s.charAt(start));
            }

            start++;
        }

        return sb;

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
