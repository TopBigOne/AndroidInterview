package string.leet_code_151;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/3/25 19:32
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ReverseWords9 {

    public String reverseWords(String s) {
        // 1: 去掉字符串首，尾部，和中间的字符串
        StringBuilder sb = removeUnusedSpace(s);
        // 2: 反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3: 反转整个words
        reverseEachWord(sb);
        return sb.toString();
    }

    private void reverseString(StringBuilder sb, int start, int end) {

    }

    private void reverseEachWord(StringBuilder sb) {

    }

    private StringBuilder removeUnusedSpace(String s) {

        StringBuilder sb = new StringBuilder();
        return sb;
    }
}
