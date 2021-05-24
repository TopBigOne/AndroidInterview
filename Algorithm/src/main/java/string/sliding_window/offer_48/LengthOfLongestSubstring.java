package string.sliding_window.offer_48;

/**
 * @author : dev
 * @version :
 * @Date :  5/24/21 11:27 PM
 * @Desc : 字节：7 次； 最长不含重复子串：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongSubstring(String s) {
        int result = 0;
        int length;
        if (s == null || (length = s.length()) == 0) {
            return result;
        }
        int[] map = new int[256];
        int left = 0;
        for (int right = 0; right < length; right++) {
            char rightChar = s.charAt(right);
            map[rightChar]++;

            while (map[rightChar]>1){
                char leftChar = s.charAt(left);
                map[leftChar]--;
                left++;
            }
            result  = Math.max(result,right-left+1);
        }
        return result;

    }
}
