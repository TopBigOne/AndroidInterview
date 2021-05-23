package string.sliding_window.leet_code_76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  5/22/21 9:35 PM
 * @Desc : leetcode 76 ：最小窗口，困难，字节：26 次：https://leetcode-cn.com/problems/minimum-window-substring/
 * <p>
 * video: https://www.youtube.com/watch?v=WtSq5lAdg7M
 * <p>
 * <p>
 * 一姐： https://www.youtube.com/watch?v=IzynHx-O4lE
 * https://www.youtube.com/watch?v=WtSq5lAdg7M
 *
 * 伟伟：https://leetcode-cn.com/problems/minimum-window-substring/solution/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution/
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        // 存放不重复的字符串出现额次数
        Map<Character, Integer> need = new HashMap<>(16);
        Map<Character, Integer> window = new HashMap<>(16);
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 左右滑动窗口的左右指针
        int left = 0;
        int right = 0;
        // 表示满足了 t 中的字符，不算重复的
        int valid = 0;
        // 记录 最小覆盖子串的起始索引及长度
        int start = 0;

        int len = Integer.MAX_VALUE;


        while (right < s.length()) {
            // c 将是移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            //  进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断是否需要收缩（即已经找到了合适的覆盖串）
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (len > right - left) {
                    len = right - left;
                    start = left;

                }
                char tempC = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                // 如果当前要移动的字符是包含在 need 中，
                // 我们需要进行讨论，如果该字符的次数刚好与我们需要的次数相等，
                // 则 valid--,并同时更新 window 中这个值出现的次数
                if (need.containsKey(tempC)) {
                    if (window.get(tempC).equals(need.get(tempC))) {
                        valid--;
                    }
                    window.put(tempC, window.getOrDefault(tempC, 0) - 1);
                }

            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

    }
}
