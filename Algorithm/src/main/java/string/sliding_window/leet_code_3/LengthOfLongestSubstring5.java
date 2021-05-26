package string.sliding_window.leet_code_3;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/25 10:45
 * @Desc : 无重复最长子串
 */
public class LengthOfLongestSubstring5 {
    public int lengthOfLongestSubstring(String s) {
        int length;
        int result = 0;
        if (s == null || (length = s.length()) == 0) {
            return result;
        }
        int[] map = new int[256];
        int left = 0;
        for (int right = 0; right < length; right++) {
            char currChar = s.charAt(right);
            map[currChar]++;
            while (map[currChar] > 1) {
                char leftChar = s.charAt(left);
                map[leftChar]--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;

    }
}
