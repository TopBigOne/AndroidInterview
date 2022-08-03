package string.leet_code_14;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/3 18:00
 * @Desc :
 */
public class LongestCommonPrefix2 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        LongestCommonPrefix2 longestCommonPrefix = new LongestCommonPrefix2();
        String result = longestCommonPrefix.longestCommonPrefix(strs);
        System.err.println("result : " + result);
    }

    public String longestCommonPrefix(String[] strs) {
        int len;
        if (strs == null || (len = strs.length) == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 0; i < len; i++) {
            while (!strs[i].startsWith(pre)) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;

    }

    public String longestCommonPrefix2(String[] strs) {

        if (strs == null || (strs.length) == 0) {
            return "";
        }
        String pre = strs[0];
        for (String str : strs) {
            while (!str.startsWith(pre)) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;

    }
}
