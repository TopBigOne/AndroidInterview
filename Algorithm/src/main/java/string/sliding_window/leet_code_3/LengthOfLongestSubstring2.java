package string.sliding_window.leet_code_3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/5 23:32
 * @Desc :
 *  滑动窗口
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
 */
public class LengthOfLongestSubstring2 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

}
