package string.leet_code_409;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/28 23:53
 * @Url : https://leetcode-cn.com/problems/longest-palindrome/submissions/
 * @Level :  easy
 * @Desc : 最长回文串
 * @Counter :
 * @Answer :
 * https://leetcode-cn.com/problems/longest-palindrome/solution/javade-2chong-shi-xian-fang-fa-by-sweetiee/
 * 题解：
 * https://leetcode-cn.com/problems/longest-palindrome/solution/qi-shi-hen-jian-dan-wen-ti-de-ben-zhi-ji-1mhr/
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }

        int ans = 0;
        for (int x : cnt) {
            // 字符出现的次数最多用偶数次。
            ans += x - (x & 1);
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return ans < s.length() ? ans + 1 : ans;
    }

    public int longestPalindrome2(String s) {
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }
        int ans = 0;
        for (int x : cnt) {
            ans += x - (x & 1);
        }

        return ans < s.length() ? ans + 1 : ans;

    }


}



