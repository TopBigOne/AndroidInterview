package packsack.leet_code_139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/9 00:24
 * @Desc : 139: 单词拆分：https://leetcode-cn.com/problems/word-break/
 */
public class WordBreak2 extends Base {
    public static void main(String[] args) {
        WordBreak2 wordBreak = new WordBreak2();
        String s = "leetcode";
        boolean result = wordBreak.wordBreak(s, wordBreak.listOne());
        System.err.println("result : " + result);
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int sLength = s.length();
        boolean[] dp = new boolean[sLength + 1];
        dp[0] = true;

        for (int i = 1; i <= sLength; i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                System.err.println("substring : " + substring);
                if (dp[j] && set.contains(substring)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[sLength];

    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dp[j] && set.contains(substring)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];

    }

    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String subStr = s.substring(j, i);
                if (dp[j] && set.contains(subStr)) {
                    dp[i] = true;
                    break;
                }
            }

        }
        return dp[len];


    }

}
