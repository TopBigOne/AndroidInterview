package two_point.leet_code_151;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/20 10:18
 * @Url :
 * @Level :    medium
 * @Desc :  反转字符串里的单词
 * @Counter :
 * @Answer :
 */
public class ReverseWords3 {
    public String reverseWords(String s) {
        // 1: 去掉s前后和中间多余的空格;
        StringBuilder sb = removeSpaces(s);
        // 2: 反转整个字符串;
        reverseString(sb, 0, sb.length());
        // 3: 反转每个单词;
        reverseEachWord(sb);
        return sb.toString();
    }

    /**
     * 移除字符串中
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
            while (currChar != ' ' && sb.charAt(sb.length() - 1) != ' ') {
                sb.append(currChar);
            }
            start++;
        }
        return sb;
    }

    private StringBuilder removeSpaces2(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;

        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            int currChar = s.charAt(start);
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

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int len = sb.length();
        while (start < len) {
            while (end < len && sb.charAt(start) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

    private void reverseEachWord2(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int len = sb.length();
        while (start < len) {
            while (end < len && sb.charAt(start) != ' ') {
                end++;
            }
            // end 遇见了一个空格
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

    private void reverseEachWord3(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int len = sb.length();
        while (start < len) {
            while (end < len && sb.charAt(start) != ' ') {
                end++;
            }
            reverseString2(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

    private void reverseString2(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }


}
