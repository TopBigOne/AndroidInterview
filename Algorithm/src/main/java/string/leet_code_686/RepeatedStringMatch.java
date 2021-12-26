package string.leet_code_686;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/22 22:30
 * @Url :https://leetcode-cn.com/problems/repeated-string-match/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/repeated-string-match/solution/gong-shui-san-xie-yi-ti-san-jie-qia-chan-3hbr/
 */
public class RepeatedStringMatch {

    /**
     * KMP
     *
     * @param a
     * @param b
     * @return
     */
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) {
            sb.append(a);
        }
        sb.append(a);
        int idx = strStr(sb.toString(), b);
        if (idx == -1) {
            return -1;
        }
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }

    private int strStr(String ss, String pp) {
        if (pp.isEmpty()) {
            return 0;
        }

        // 分别读取原串和匹配字符串的长度
        int n = ss.length();
        int m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从1开始
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建next数组，数组的长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程i= 2；j = 0 开始，i小于等于匹配串长度【构造i从2开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j= next(j)
            while (j > 0 && p[i] != p[j + 1]) {
                j = next[j];
            }
            if (p[i] == p[j + 1]) {
                j++;
            }
            next[i] = j;
        }

        // 匹配过程： i= 1；j = 0 开始，i 小于等于原串长度【匹配i从1开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配成功，j = next[j]
            while (j > 0 && s[i] != p[j + 1]) {
                j = next[j];
            }
            // 匹配成功的话，先让j++，结束本次循环后 i++;
            if (s[i] == p[j + 1]) {
                j++;
            }

            // 整一段匹配成功，直接返回下标
            if (j == m) {
                return i - m;
            }

        }
        return -1;

    }


}
