package string.leet_code_151;

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
        ReverseWords8 reverseWords8 = new ReverseWords8();


    }
    public String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length()-1);
        reverseEachWord(sb);
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
        while (start < end) {
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
