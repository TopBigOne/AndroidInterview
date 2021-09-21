package string.leet_code_1121;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/17 23:27
 * @Url : https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 * @Level :  easy
 * @Desc :  在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * <p>
 * 给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
 * <p>
 * 注意：分割得到的每个字符串都必须是平衡字符串。
 * <p>
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 * @Counter : 2
 * @Answer :
 */
public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int ans = 0;
        for (int i = 0; i < len; ) {
            int j = i + 1;
            int score = cs[i] == 'L' ? 1 : -1;
            while (j < len && score != 0) {
                score += cs[j++] == 'L' ? 1 : -1;
            }
            i = j;
            ans++;

        }
        return ans;

    }
}
