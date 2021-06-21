package sliding_window.leet_code_3;

/**
 * @author : dev
 * @version :
 * @Date :  6/1/21 11:13 PM
 * @Desc : 最长无重复子串  https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 字节半年
 * <p>
 * 一姐：https://www.youtube.com/watch?v=EbemoR4LooA&t=137s
 */
public class LengthOfLongestSubstring6 {
    /**
     * Solution:Two Pointers(Sliding window)
     * 1. maintain a sliding window [start....end],making sure that each char in such window ,
     * its frequency is 1 (without Repeating chars)
     * 2. when one char`s frequency>1,there is repeating char , then move pointer start to find
     * the next window.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int length;
        int result = 0;
        //1:  corner case
        if (s == null || ((length = s.length()) == 0)) {
            return result;
        }

        // 简化的 map（ascII 表，字符是 256 个）
        int[] map = new int[256];
        int start = 0;
        for (int end = 0; end < length; end++) {
            // 当前字符
            char currChar = s.charAt(end);
            //
            map[currChar]++;
            while (map[currChar] > 1) {
                // 踢出 start 所对应的 字符，直到 currentChar 在当前动态变化的窗口中，没有重复
                map[s.charAt(start)]--;
                // start 往右边移动；
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;

    }
}
