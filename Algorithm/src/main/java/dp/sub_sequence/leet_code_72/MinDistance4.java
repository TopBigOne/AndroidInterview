package dp.sub_sequence.leet_code_72;

/**
 * @author : dev
 * @version :
 * @Date :  8/9/21 11:21 PM
 * @Desc : 题解：https://labuladong.github.io/algo/3/24/73/
 */

/**
 * @author :  dev
 * @version :
 * @Date :   8/9/21 11:21 PM
 * @Url :https://leetcode-cn.com/problems/edit-distance/submissions/
 * @Level :     hard
 * @Desc :  leetcode_72: 编辑距离：
 * @Counter :
 * @Answer :
 * <p>
 * <p>
 * 同类问题
 * 「力扣」第 1143 题：最长公共子串（中等）；
 * 「力扣」第 10 题：正则表达式匹配（困难）；
 * 「力扣」第 44 题：通配符匹配（困难）；
 * 「力扣」第 97 题：交错字符串（困难）；
 * 「力扣」第 115 题： 不同的子序列（困难）；
 * 「力扣」第 583 题：两个字符串的删除操作（中等）；
 * 「力扣」第 718 题：最长重复子数组（中等）；
 * 「力扣」第 1035 题：不相交的线（中等）；
 * 「力扣」第 1092 题： 最短公共超序列（困难）。
 */
public class MinDistance4 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                // 1:insert
                //  直接在 s1[i] 插入一个和 s2[j] 一样的字符
                //  那么 s2[j] 就被匹配了，前移 j，继续跟 i 对比
                int insert = dp[i][j - 1] + 1;

                // 2: replace
                // 直接把 s1[i] 替换成 s2[j]，这样它俩就匹配了
                int replace = dp[i - 1][j - 1] + 1;

                // 3:delete
                // 我直接把 s[i] 这个字符删掉,前移 i，继续跟 j 对比
                int delete = dp[i - 1][j] + 1;
                dp[i][j] = Math.min(delete, Math.min(replace, insert));
            }
        }
        return dp[len1][len2];

    }
}
