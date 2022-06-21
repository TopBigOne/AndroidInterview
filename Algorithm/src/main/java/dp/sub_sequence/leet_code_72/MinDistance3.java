package dp.sub_sequence.leet_code_72;

/**
 * @author :  dev
 * @version :
 * @Date :   8/7/21 11:20 PM
 * @Url :https://leetcode-cn.com/problems/edit-distance/submissions/
 * @Level :  easy  medium hard
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
public class MinDistance3 {
    public int minDistance3(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < len2; i++) {
            dp[0][i] = i;
        }
        char[] wordArray1 = word1.toCharArray();
        char[] wordArray2 = word2.toCharArray();
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j < len2; j++) {
                // 这是最佳情况
                if (wordArray1[i - 1] == wordArray2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                // 反之，在以下三种情况中选出步骤最少的，这是【动态规划】的最优子结构
                // 1:insert ,在下标 i 处 插入一个字符
                int insert = dp[i][j - 1] + 1;
                // 2：replace ：替换一个字符
                int replace = dp[i - 1][j - 1] + 1;
                // 3: delete 删除一个字符
                int delete = dp[i - 1][j] + 1;
                dp[i][j] = Math.min(Math.min(insert, replace), delete);
            }
        }
        return dp[len1][len2];
    }
}
