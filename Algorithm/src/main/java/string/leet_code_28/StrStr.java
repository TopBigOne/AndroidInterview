package string.leet_code_28;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/4 17:04
 * @Url :    https://leetcode-cn.com/problems/implement-strstr/submissions/
 * @Level : easy
 * @Desc : 实现 strStr()
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/implement-strstr/solution/shua-chuan-lc-shuang-bai-po-su-jie-fa-km-tb86/
 */
public class StrStr {

    public static void main(String[] args) {
        StrStr strStr = new StrStr();

    }

    /**
     * 默认解法
     *
     * @param ss hello
     * @param pp ll
     * @return index.
     */
    public int strStr(String ss, String pp) {
        int n = ss.length();
        int m = pp.length();
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        // 枚举原串的【发起点】
        for (int i = 0; i <= n - m; i++) {
            // 从原串的【发起点】和匹配串的【首位】开始，尝试匹配
            int a = i;
            int b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的【发起点】 下标
            if (b == m) return i;
        }
        return -1;
    }

    public int strStr2(String ss, String pp) {
        int n = ss.length();
        int m = pp.length();
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        for (int i = 0; i <= n - m; i++) {
            int a = i;
            int b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }

            if (b == m) return i;
        }
        return -1;

    }

    public int strStr3(String ss, String pp) {
        int n = ss.length();
        int m = pp.length();
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        for (int i = 0; i <= n - m; i++) {
            int a = i;
            int b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }

            if (b == m) {
                return i;
            }
        }
        return -1;
    }


    public int strStr4(String ss, String pp) {
        int n = ss.length();
        int m = pp.length();
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        for (int i = 0; i <= n - m; i++) {
            int a = i;
            int b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            if (b == m) {
                return i;
            }
        }

        return -1;
    }


}