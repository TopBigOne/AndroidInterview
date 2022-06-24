package dp.sub_sequence.leet_code_392;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/1 23:29
 * @Url : https://leetcode-cn.com/problems/is-subsequence/submissions/
 * @Level :  easy
 * @Desc : 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/is-subsequence/solution/javati-jie-he-hou-xu-tiao-zhan-by-lil-q/
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String s = "acb";
        String t = "ahbgdc";
        IsSubsequence isSubsequence = new IsSubsequence();
        isSubsequence.isSubsequence(s, t);

    }

    /**
     * @param s 短串
     * @param t 长串
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int tLength = t.length();
        int i = 0;
        for (char ch : s.toCharArray()) {
            System.out.println("短串的字符: " + ch);
            // 找到 t 上第一个匹配的 ch
            while (i < tLength && t.charAt(i) != ch) {
                i++;
            }
            // 如果 t 穷尽，跳出，注意始终对 i 加一
            if (i++ >= t.length()) {
                break;
            }
        }
        return i <= t.length();
    }

    public boolean isSubsequence2(String s, String t) {
        int tLength = t.length();
        int index = 0;
        for (char ch : s.toCharArray()) {
            while (index < tLength && t.charAt(index) != ch) {
                index++;
            }
            if (index++ >= tLength) {
                break;
            }
        }
        return index <= tLength;
    }

    public boolean isSubsequence3(String s, String t) {
        int tLength = t.length();
        int index = 0;
        for (char ch : s.toCharArray()) {
            while (index < tLength && t.charAt(index) != ch) {
                index++;
            }

            if (index++ >= tLength) {
                break;
            }
        }
        return index < tLength;

    }

    public boolean isSubsequence4(String s, String t) {
        int tLength = t.length();
        int index = 0;
        for (char ch : s.toCharArray()) {
            while (index < tLength && t.charAt(index) != ch) {
                index++;
            }
            if (index++ >= tLength) {
                break;
            }
        }
        return index <= tLength;

    }
}
