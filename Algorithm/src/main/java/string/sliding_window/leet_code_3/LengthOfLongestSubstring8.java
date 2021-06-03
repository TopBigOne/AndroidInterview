package string.sliding_window.leet_code_3;

/**
 * @author : dev
 * @version :
 * @Date :  6/4/21 12:35 AM
 * @Desc :https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 应用层
 * 传输层
 * 网络控制层
 * 链路层
 * 物理层；
 */
public class LengthOfLongestSubstring8 {
    public int lengthOfLongestSubStirng(String s) {
        // corner base
        int result = 0;
        int length;
        if (s == null || (length = s.length()) == 0) {
            return result;
        }
        int left = 0;
        int[] map = new int[256];
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
