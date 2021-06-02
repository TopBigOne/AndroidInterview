package string.sliding_window.leet_code_3;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/2 10:20
 * @Url :
 * @Level :  medium
 * @Desc : leetcode  无重复的最长子串
 * @Counter :
 * @Answer :
 */
public class LengthOfLongestSubstring7 {
    public int lengthOfLongestSubstring(String s) {
        // 1: corner base
        int result = 0;
        int length;
        if (s == null || ((length = s.length()) == 0)) {
            return result;
        }
        int[] map = new int[256];
        int left = 0;
        for (int right = 0; right < length; right++) {
            char currChar = s.charAt(right);
            map[currChar]++;
            while (map[currChar] > 1) {
                map[s.charAt(left)]--;
                left++;
            }

            result = Math.max(result, right - left + 1);
        }
        return result;


    }
}
