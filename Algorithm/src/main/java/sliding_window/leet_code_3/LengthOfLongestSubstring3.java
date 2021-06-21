package sliding_window.leet_code_3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  5/22/21 1:00 PM
 * @Desc : leetcode :03 : 字节：56次中等 ：无重复最长子串 ：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * <p>
 * 滑动窗口:
 * 题解：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
 *
 * 一姐:https://www.youtube.com/watch?v=EbemoR4LooA&t=137s
 */
public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        int length;
        if (s == null || (length = s.length()) == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>(length);
        int max = 0;
        int left = 0;
        int right;

        for (right = 0; right < length; right++) {
            // 当前字符
            char currChar = s.charAt(right);
            if (map.containsKey(currChar)) {
                left = Math.max(left, map.get(currChar) + 1);
            }
            map.put(currChar, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int length;
        if (s == null || (length = s.length()) == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>(length);
        int max = 0;
        int left = 0;
        for (int right = 0; right < length; right++) {
            char currChar = s.charAt(right);
            if (map.containsKey(currChar)) {
                left = Math.max(left, map.get(currChar) + 1);
            }
            // 不包含,直接放进入，并记住当前 字符的 index
            map.put(currChar, right);

            // 每次做一下大小比较,right-left :是获取一个范围
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public int lengthOfLongestSubstring3(String s) {
        int length;
        if (s == null || (length = s.length()) == 0) {
            return 0;
        }
        int max = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>(length);

        for (int right = 0; right < length; right++) {
            char currChar = s.charAt(right);
            if (map.containsKey(currChar)) {
                left = Math.max(left, map.get(currChar) + 1);
            }
            map.put(currChar, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring4(String s) {
        int length;
        if (s == null || (length = s.length()) == 0) return 0;
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>(length);
        for (int right = 0; right < length; right++) {
            char currChar = s.charAt(right);
            if (map.containsKey(currChar)) {
                left = Math.max(left, map.get(currChar) + 1);
            }
            map.put(currChar, right);
            max = Math.max(max, right - left + 1);
        }

        return max;

    }

    /**
     * 最长无重复子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubString5(String s) {
        int length;
        if (s == null || (length = s.length()) == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>(length);
        for (int right = 0; right < length; right++) {
            char currChar = s.charAt(right);
            if (map.containsKey(currChar)) {
                // 右移一位
                left = Math.max(left, map.get(currChar) + 1);
            }
            map.put(currChar, right);
            max = Math.max(max, right - left + 1);

        }

        return max;
    }

    /**
     * 最长无重复子串的长度
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubString(String s) {
        int length;
        if (s == null || (length = s.length()) == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>(length);
        for (int right = 0; right < length; right++) {
            char currChar = s.charAt(right);
            if (map.containsKey(currChar)) {
                left = Math.max(left, map.get(currChar) + 1);
            }
            // 当前字符出现的
            map.put(currChar, right);
            max = Math.max(max, right - left + 1);

        }
        return max;

    }



}
