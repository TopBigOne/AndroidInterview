package sliding_window.leet_code_3;

/**
 * @author : dev
 * @version :
 * @Date :  6/30/21 10:29 PM
 * @Desc : 无重复字符最长子串：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

public class LengthOfLongestSubstring9 {
    public static void main(String[] args) {
        String s = "pwwkew";
        LengthOfLongestSubstring9 sub = new LengthOfLongestSubstring9();
        int result = sub.lengthOfLongestSubstring(s);
        System.out.println("result:" + result);
    }

    /**
     * @param s 测试用例 :"pwwkew"
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int len;
        // base corner
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] map = new int[256];
        int left = 0;

        System.out.println("raw   length: " + len);
        System.out.println("chars length: " + chars.length);

        for (int right = 0; right < len; right++) {
            int currChar = chars[right];
            map[currChar]++;
            while (map[currChar] > 1) {
                char leftChar = s.charAt(left);
                // 左边存储的字符做--，便于去掉重复的字符
                map[leftChar]--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        int len;
        // base corner
        if (s == null || (len = s.length()) == 0) {
            return result;
        }
        int left = 0;
        int[] map = new int[256];
        char[] chars = s.toCharArray();

        for (int right = 0; right < len; right++) {
            char curChar = chars[right];
            map[curChar]++;
            while (map[curChar] > 1) {
                char leftChar = s.charAt(left);
                map[leftChar]--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public int lengthOfLongestSubstring3(String s) {
        int result = 0;
        int len = 0;
        // base corner
        if (s == null || (len = s.length()) == 0) {
            return result;
        }

        int left = 0;
        int[] map = new int[256];
        for (int right = 0; right < len; right++) {
            char currChar = s.charAt(right);
            // store it;
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

    /**
     * leetcode 第三题：无重复最长子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring4(String s) {
        int result = 0;
        int len = 0;
        // base corner
        if (s == null || (len = s.length()) == 0) {
            return result;
        }
        int left = 0;
        int[] map = new int[256];
        for (int i = 0; i < len; i++) {
            char currChar = s.charAt(i);
            map[currChar]++;
            // 存在重复
            while (map[currChar] > 1) {
                char leftChar = s.charAt(left);
                map[leftChar]--;
                left++;
            }
            result = Math.max(result, i - left + 1);
        }
        return result;

    }

    public int lengthOfLongestSubstring5(String s) {
        int result = 0;
        int len = 0;
        // step 1 : base corner
        if (s == null || (len = s.length()) == 0) {
            return result;
        }

        int left = 0;
        int[] map = new int[256];
        for (int i = 0; i < len; i++) {
            char currChar = s.charAt(i);
            map[currChar]++;
            while (map[currChar] > 1) {
                char leftChar = s.charAt(left);
                map[leftChar]--;
                left++;
            }
            result = Math.max(result, i - left + 1);
        }
        return result;
    }

    public int lengthOfLongestSubstring6(String s) {
        int len = 0;
        int res = 0;
        if (s == null || (len = s.length()) == 0) {
            return res;
        }

        int left = 0;
        int[] windows = new int[256];
        for (int i = 0; i < len; i++) {
            char currChar = s.charAt(i);
            windows[currChar]++;

            while (windows[currChar] > 1) {
                char leftChar = s.charAt(left);
                windows[leftChar]--;
                left++;
            }

            res = Math.max(res, i - left + 1);
        }

        return res;

    }


}
