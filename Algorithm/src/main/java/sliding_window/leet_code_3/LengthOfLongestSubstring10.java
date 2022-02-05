package sliding_window.leet_code_3;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/4 03:41
 * @Url :https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Level :    medium
 * @Desc : 最长无重复子串
 * @Counter :
 * @Answer :
 */
public class LengthOfLongestSubstring10 {
    public int lengthOfLongestSubstring(String s) {
        int length;
        int result = 0;
        if (s == null || (length = s.length()) == 0) {
            return result;
        }
        int[] windows = new int[256];
        int left = 0;
        for (int i = 0; i < length; i++) {
            char rightChar = s.charAt(i);
            windows[rightChar]++;

            while (windows[rightChar] > 1) {
                char leftChar = s.charAt(left);
                windows[leftChar]--;
                left++;
            }
            result = Math.max(result, i - left + 1);

        }
        return result;

    }
}
