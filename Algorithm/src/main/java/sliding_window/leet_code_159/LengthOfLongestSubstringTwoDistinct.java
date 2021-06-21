package sliding_window.leet_code_159;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  6/2/21 11:59 PM
 * @Desc :  159. 至多包含两个不同字符的最长子串 字节：2 次； https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/
 *
 * 题解：https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/solution/java-hua-dong-chuang-kou-by-lyl0724-2/
 */
public class LengthOfLongestSubstringTwoDistinct {
    public static void main(String[] args) {
        String s = "eceba";
        LengthOfLongestSubstringTwoDistinct longestSubstringTwoDistinct = new LengthOfLongestSubstringTwoDistinct();
        int result = longestSubstringTwoDistinct.lengthOfLongestSubstringTwoDistinct2(s);
        System.out.println("result : "+result);
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
        for(int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            }else {
                map.put(c, map.get(c) + 1);
            }

            while(map.size() > 2) {
                char leftChar = s.charAt(l++);
                int value = map.get(leftChar) - 1;
                if(value == 0) {
                    map.remove(leftChar);
                }else {
                    map.put(leftChar, value);
                }
            }
            res = Math.max(res, r - l + 1);
        }

        return res;


    }

}
