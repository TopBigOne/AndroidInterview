package sliding_window.leet_code_3;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/18 14:03
 * @Desc :
 */
public class LengthOfLongestSubstring13 {
    public int lengthOfLongestSubstring(String s) {
        int len;
        int maxLength = 0;
        if (s == null || (len = s.length()) == 0) {
            return maxLength;
        }

        int[] windows = new int[256];
        int left = 0;
        int right = 0;
        while (right < len - 1) {
            char rightChar = s.charAt(right);
            windows[rightChar]++;

            while (windows[rightChar] > 1) {
                char leftChar = s.charAt(left);
                windows[leftChar]--;
                left++;

            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;

        }

        return maxLength;
    }


}
