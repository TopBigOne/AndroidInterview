package dp.leet_code_139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/9 00:24
 * @Desc :
 */
public class WordBreak2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int sLength = s.length();
        boolean[] dp = new boolean[sLength + 1];
        dp[0] = true;

        for (int i = 1; i <= sLength; i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                System.err.println("substring : "+substring);
                if (dp[j] && set.contains(substring)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[sLength];

    }

}
