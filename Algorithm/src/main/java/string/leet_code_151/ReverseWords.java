package string.leet_code_151;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/19 19:21
 * @Url :https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/
 * @Level :    medium
 * @Desc : 反转字符串里的单词
 * @Counter : 3
 * @Answer : https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/151-zong-he-kao-cha-liao-zi-fu-chuan-cao-yr8q/
 */
public class ReverseWords {
    public static void main(String[] args) {
        String rawStr = "    I    love  you ";
        ReverseWords reverse = new ReverseWords();
        String result = reverse.reverseWords(rawStr);
        System.out.println("result: " + result);
    }

    public String reverseWords(String s) {
        // 去掉首尾以及中间多余空格
        StringBuilder sb = removeSpaces(s);
        // 反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();

    }

    /**
     * 去掉首尾中间额空格
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
            char c = s.charAt(start);

            // 当c是空的时候，判断一下sb的最后一个是不是空，是的话，就不追加空字符了，不是的话，就追加一个空字符
            if (c != ' ' || sb.charAt(sb.length() - 1)!= ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    /**
     * 反转指定区间[start,end] 的字符串
     *
     * @param sb
     * @param start
     * @param end
     */
    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    /**
     * 反转每一个单词
     * @param sb
     */
    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            // 找到当钱需要反转 单词的起始下标
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }


}
