package sliding_window.leet_code_340;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  6/1/21 11:36 PM
 * @Desc : leetcode 340 字节 2 次：至多包含 k 个不同字符的最长子串 https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * <p>
 *     题解：https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters/solution/zhi-shao-bao-han-k-ge-bu-tong-zi-fu-de-zui-chang-z/
 * <p>
 * 可以看看，leetcode 159：https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/
 */
public class LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        int maxLen = 1;
        while (right < n) {
            hashMap.put(s.charAt(right), right++);
            if (hashMap.size() == k + 1) {
                int delIndex = Collections.min(hashMap.values());
                hashMap.remove(s.charAt(delIndex));
                left = delIndex + 1;
            }
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;


    }
}
