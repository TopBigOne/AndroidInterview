package sliding_window.leet_code_3;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/3/1 14:01
 * @Url : https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class LengthOfLongestSubstring11 {
    public int lengthOfLongestSubstring(String s) {
        int len;
        int result = 0;
        if (s == null || (len = s.length()) == 0) {
            return result;
        }
        int[] windows = new int[256];
        int left = 0;
        for (int right = 0; right < len; right++) {
            char currChar = s.charAt(right);
            windows[currChar]++;
            while (windows[currChar] > 1) {
                char leftChar = s.charAt(left);
                windows[leftChar]--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;

    }
}
