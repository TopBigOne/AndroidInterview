package two_point.leet_code_151;

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
    public static void main(String[] args) {
        String s = "  hello world!  ";
        ReverseWords9 reverseWords9 = new ReverseWords9();
        String result = reverseWords9.reverseWords(s);
        System.out.println("result : " + result);
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        // 1: 去掉字符串首，尾部，和中间的字符串
        StringBuilder sb = removeUnusedSpace(s);
        // 2: 反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3: 反转整个words
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder removeUnusedSpace(String s) { // " "
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }

        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char leftChar = s.charAt(start);


            // sb.charAt(sb.length() - 1) != ' ' : 防止重复添加空格；
            if (leftChar != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(leftChar);
            }
            start++;
        }

        return sb;
    }

    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char tempChar = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, tempChar);
            start++;
            end--;
        }
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int length = sb.length();
        while (start < length) {
            //找到end点
            while (end < length && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }

    }


}
