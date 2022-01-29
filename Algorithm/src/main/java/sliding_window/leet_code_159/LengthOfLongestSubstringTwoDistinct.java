package sliding_window.leet_code_159;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;

/**
 * @author : dev
 * @version :
 * @Date :  6/2/21 11:59 PM
 * @Desc :  159. 至多包含两个不同字符的最长子串 字节：2 次； https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * <p>
 * 题解：https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/solution/java-hua-dong-chuang-kou-by-lyl0724-2/
 */
public class LengthOfLongestSubstringTwoDistinct {
    public static void main(String[] args) {
        String s = "eceba";
        LengthOfLongestSubstringTwoDistinct longestSubstringTwoDistinct = new LengthOfLongestSubstringTwoDistinct();
        int result = longestSubstringTwoDistinct.lengthOfLongestSubstringTwoDistinct3(s);
        System.out.println("result : " + result);
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[256];
        int res = 0;
        int left = 0;
        for (int r = 0; r < s.length(); r++) {
            char currentChar = s.charAt(r);
            map[currentChar]++;

            while (map[currentChar] > 2) {
                char leftChar = s.charAt(left);
                map[left]--;
                left++;
            }
            res = Math.max(res, r - left + 1);
        }

        return res;
    }

    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }

            while (map.size() > 2) {
                char leftChar = s.charAt(l++);

                int value = map.get(leftChar) - 1;

                if (value == 0) {
                    map.remove(leftChar);
                } else {
                    map.put(leftChar, value);
                }
            }
            res = Math.max(res, r - l + 1);
        }

        return res;

    }

    public int lengthOfLongestSubstringTwoDistinct3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);
            // 统计每个字母出现的次数
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);


            // 两个字母
            while (map.size() > 2) {
                char leftChar = s.charAt(left);
                int leftValue = map.get(leftChar) - 1;
                if (leftValue == 0) {
                    map.remove(leftChar);
                } else {
                    map.put(leftChar, leftValue);
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
        }
        return res;

    }

    public int lengthOfLongestSubstringTwoDistinct4(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (right = 0; right < length; right++) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            while (map.size() > 2) {
                char leftChar = s.charAt(left);
                int charCount = map.get(leftChar);
                if (charCount - 1 == 0) {
                    map.remove(leftChar);
                } else {
                    map.put(leftChar, charCount - 1);
                }
                left++;

            }
            res = Math.max(res, right - left + 1);

        }
        return res;
    }

    public int lengthOfLongestSubstringTwoDistinct5(String s) {
        char ZERO = '0';
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len < 3) {
            return len;
        }
        int[] window = new int[128];
        int left = 0, right = 0;
        int count = 0, ans = 0;
        while (right < len) {
            char rightChar = chars[right];
            if (window[rightChar - ZERO] == 0) {
                count++;
            }
            window[rightChar - ZERO]++;

            while (count > 2) {
                char leftChar = chars[left];
                window[leftChar - ZERO]--;
                if (window[leftChar - ZERO] == 0) {
                    count--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    public int lengthOfLongestSubstringTwoDistinct6(String s) {
        int left = 0;
        int right = 0;
        int[] window = new int[256];
        int count = 0;
        int result = 0;

        int length = s.length();

        if(length<3){
            return length;
        }

        char ZERO = '0';
        while (right < length) {
            char rightChar = s.charAt(right);
            if (rightChar - ZERO == 0) {
                count++;
            }
            window[rightChar - ZERO]++;
            while (count > 2) {
                char leftChar = s.charAt(left);
                window[leftChar - ZERO]--;
                if (window[leftChar - ZERO] == 0) {
                    count--;
                }
                left++;
            }
            result = Math.max(result, right - left + 1);

            right++;
        }

        return result;

    }


}
