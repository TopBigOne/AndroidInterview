package string.leet_code_151;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/20 11:10
 * @Url :
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ReverseWords4 {
    public String reverseWords(String s) {
        // 1: 去掉字符串首尾和中间多余的字符串
        StringBuilder sb = removeSpaces(s);
        // 2: 反转整个字符串
        reverseString(sb, 0, sb.length());
        // 3: 反转每个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpaces(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;

        StringBuilder sb = new StringBuilder();
        // 是不是有点像单调栈
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
