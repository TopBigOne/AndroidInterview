package packsack.leet_code_139;

import java.util.Arrays;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/26 00:15
 * @Url : https://leetcode-cn.com/problems/word-break/
 * @Level :    medium
 * @Desc :  给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * @Counter :  13
 * @Answer : https://leetcode-cn.com/problems/word-break/solution/dong-tai-gui-hua-ji-yi-hua-hui-su-zhu-xing-jie-shi/
 */
public class WordBreak extends Base {
    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        String s = "leetcode";
        boolean result = wordBreak.wordBreak(s, wordBreak.listOne());
        System.err.println("result : " + result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];

        // fill(dp + 1, dp + len + 1, false);
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            // dp[i-1] 是false时，是无法完成拆分的，指针i跳到下一个index
            if (!dp[i - 1]) {
                continue;
            }
            // 能执行到这，说明子串s[0:i-1] 都是能拆分的，遍历数组wordDict，尝试从s中取出新的子串
            // (这个子串的长度和当前循环的word相等，即：s[i-1:j]),如果这个子串恰好与当前word相同
            // 那么子串s[0:j]也都是能拆分的，重复以上过程
            for (String word : wordDict) {

                int wordLength = word.length();
                int j = i - 1 + wordLength;

                String subWord = s.substring(i - 1, wordLength);
                System.err.println("subWord : " + subWord);
                // 指针j不能越界，
                if (j <= len && subWord.equals(word)) {
                    dp[j] = true;
                }
            }
        }
        return dp[len];
    }
}
