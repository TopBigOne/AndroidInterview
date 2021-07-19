package string.leet_code_151;


/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/19 21:11
 * @Url :https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/
 * @Level :    medium
 * @Desc : 反转字符串里的单词
 * @Counter : 3
 * @Answer : https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/151-zong-he-kao-cha-liao-zi-fu-chuan-cao-yr8q/
 */
public class ReverseWord2 {
    public String reverseWords(String s) {
        // 去掉首尾和中间的字符串
        StringBuilder sb = removeSpaces(s);
        // 反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 反转整个words
        reverseEachWord(sb);

        return sb.toString();

    }

    /**
     * 移除 字符串的首尾和中间多余的空格
     *
     * @param s
     * @return
     */
    private StringBuilder removeSpaces(String s) {
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
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

}
