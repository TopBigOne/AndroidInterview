package sliding_window.leet_code_3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author : dev
 * @version :
 * @Date :  5/22/21 1:00 PM
 * @Desc : leetcode :03 : 字节：56次中等 ：无重复最长子串 ：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 题解：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;


    }
}
