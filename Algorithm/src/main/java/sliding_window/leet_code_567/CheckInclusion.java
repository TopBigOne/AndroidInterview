package sliding_window.leet_code_567;

/**
 * @author : dev
 * @version :
 * @Date :  12/15/21 10:09 PM
 * @Desc :  https://leetcode-cn.com/problems/permutation-in-string/solution/
 * <p>
 * https://leetcode-cn.com/problems/permutation-in-string/solution/an-zi-fu-hua-dong-ruo-bao-liao-lai-shi-s-h2xq/
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) return false;
        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) cnt[c - 'a']++;
        int[] cur = new int[26];
        for (int i = 0; i < m; i++) cur[s2.charAt(i) - 'a']++;
        if (check(cnt, cur)) return true;
        for (int i = m; i < n; i++) {
            cur[s2.charAt(i) - 'a']++;
            cur[s2.charAt(i - m) - 'a']--;
            if (check(cnt, cur)) return true;
        }
        return false;

    }

    boolean check(int[] cnt1, int[] cnt2) {
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }


}
