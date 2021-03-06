package dp.sub_sequence.leet_code_72;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/26 11:25
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
public class MinDistance2 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        //初始化：当word2长度为0 时，将word1 的全部删除即可
        for (int i = 1; i < len1; i++) {
            dp[i][0] = i;
        }

        // 当word1 长度为0 时，将word1的全部删除
        for (int j = 1; j < len2; j++) {
            dp[0][j] = j;
        }

        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 这是最佳情况
                if (word1Array[i - 1] == word2Array[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                // 对“dp[i-1][j-1] 表示替换操作，
                // dp[i-1][j] 表示删除操作，
                // dp[i][j-1] 表示插入操作。”的
                // 否则在以下三种情况中选出最少的，这是【动态规划】的【最优子结构】
                // 1:在下标i处插入一个字符
                int insert = dp[i][j - 1] + 1;
                // 2:替换一个字符
                int replace = dp[i - 1][j - 1] + 1;
                // 删除一个字符
                int delete = dp[i - 1][j] + 1;
                dp[i][j] = Math.min(Math.min(insert, replace), delete);

            }
        }
        return dp[len1][len2];

    }

    public int minDistance2(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 这是最佳情况
                if (word1Array[i - 1] == word2Array[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                // 否则在以下三种情况中选出步骤最少的，这是 【动态规划】的[最优子结构]
                // 1:在下标i处插入一个字符
                int insert = dp[i][j - 1] + 1;

                // 2: 替换一个字符
                int replace = dp[i - 1][j - 1] + 1;

                // 3: 删除一个字符
                int delete = dp[i - 1][j] + 1;

                dp[i][j] = Math.min(Math.min(insert, replace), delete);
            }
        }
        return dp[len1][len2];

    }

    public int minDistance3(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 最佳情况
                if (word1Array[i - 1] == word2Array[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                // 1: insert
                int insert = dp[i][j - 1] + 1;
                // 2: replace
                int replace = dp[i - 1][j - 1] + 1;
                // 3: delete
                int delete = dp[i - 1][j] + 1;
                dp[i][j] = Math.min(Math.min(insert, replace), delete);
            }
        }
        return dp[len1][len2];

    }

    public int minDistance4(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;

        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }

        char[] word1CharArray = word1.toCharArray();
        char[] word2CharArray = word2.toCharArray();
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1CharArray[i - 1] == word2CharArray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                // 1:insert
                int insert = dp[i][j - 1] + 1;
                // 2: replace
                int replace = dp[i - 1][j - 1] + 1;
                // 3:delete
                int delete = dp[i - 1][j] + 1;
                dp[i][j] = Math.min(Math.min(insert, replace), delete);
            }
        }
        return dp[len1][len2];

    }

    public int minDistance5(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }


        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 这是最佳情况
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                // 1:insert
                int insert = dp[i][j - 1] + 1;
                // 2: replace
                int replace = dp[i - 1][j - 1] + 1;
                // 3:delete
                int delete = dp[i - 1][j] + 1;
                dp[i][j] = Math.min(insert, Math.min(replace, delete));
            }
        }
        return dp[len1][len2];
    }

    public int minDistance6(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                // 字符不相等
                int delete = dp[i - 1][j] + 1;
                int replace = dp[i - 1][j - 1] + 1;
                int insert = dp[i][j - 1] + 1;
                dp[i][j] = Math.min(delete, Math.min(replace, insert));
            }
        }
        return dp[len1][len2];

    }
}
