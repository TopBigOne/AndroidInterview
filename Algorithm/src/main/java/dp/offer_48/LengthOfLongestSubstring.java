package dp.offer_48;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/1 22:24
 * @Desc : 无重复最长子串
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        // String s = "abcabcbb"; // 3
        String s = "pwwkew";// 3
        // String s = "bbbbb";// 1
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring(s);
        System.err.println("result :" + result);
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        if (len == 0) {
            return 0;
        }

        int res = 1;
        int l = 0;
        int r = 0;
        int[] window = new int[256];
        while (r < len) {
            char rightChar = s.charAt(r);
            window[rightChar]++;
            while (window[rightChar] > 1) {
                char leftChar = s.charAt(l);
                window[leftChar]--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;

    }
}
