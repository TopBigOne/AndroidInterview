package sliding_window.leet_code_76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  5/22/21 9:35 PM
 * @Desc : leetcode 76 ：最小覆盖子串，困难，字节：26 次：https://leetcode-cn.com/problems/minimum-window-substring/
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * video: https://www.youtube.com/watch?v=WtSq5lAdg7M
 * <p>
 * <p>
 * 一姐： https://www.youtube.com/watch?v=IzynHx-O4lE
 * https://www.youtube.com/watch?v=WtSq5lAdg7M
 * <p>
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

    public String minWindow2(String s, String t) {
        String res = "";
        int sLength;
        int tLength;
        if (s == null || t == null || (sLength = s.length()) == 0 ||
                (tLength = t.length()) == 0 || sLength < tLength) {
            return res;
        }
        // 用来统计t中每个字符出现的次数
        int[] needs = new int[128];
        // 用来统计滑动窗口中没个字符出现的次数
        int[] window = new int[128];
        for (char c : t.toCharArray()) {
            needs[c]++;
        }
        int left = 0;
        int right = 0;
        // 目前有多少个字符？
        int count = 0;
        // 用来记录最短需要多少个字符
        int minLength = sLength + 1;
        while (right < sLength) {
            char ch = s.charAt(right);
            window[ch]++;
            // 如果需要该字符，并且窗口内的字符个数小于需要额字符个数
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;
            }
            // 当需要的字符都已经包含在窗口中以后，开始收缩left
            while (count == tLength) {
                ch = s.charAt(left);
                // 当需要删除的字符串，是必须留在窗口时
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    count--;
                }
                // 这边需要取 = ，因为可能一开始两个字符串就是匹配的，如 a , a return a
                if (right - left + 1 <= minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                window[ch]--;
                left++;
            }
            right++;
        }

        return res;

    }

    public String minWindow3(String s, String t) {
        String res = "";
        int sLength;
        // 需要匹配子串的长度；
        int tLength;

        if (s == null || t == null || (sLength = s.length()) == 0 ||
                (tLength = t.length()) == 0 || sLength < tLength) {
            return res;
        }
        // 目标数量；
        int targetCount = tLength;
        // t 中，每个字符出现的次数
        int[] needs = new int[128];
        // 统计滑动窗口中每个字符出现次数
        int[] window = new int[128];
        for (char c : t.toCharArray()) {
            needs[c]++;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int minLength = sLength + 1;
        while (right < sLength) {
            char currChar = s.charAt(right);
            // s字符串中，每个字符出现的频率
            window[currChar]++;

            // 如果需要该字符，并且窗口内的字符个数小于需要的字符个数
            // 1：need 中，当前字符出现的频率是否大于0；
            // 2: 当前字符currChar 在needs中出现的频率大于或者等于window 出现的频率
            if (needs[currChar] > 0 && needs[currChar] >= window[currChar]) {
                count++;
            }
            //当累计的数量与target:s 的size  ，right不动，left开始往右边收缩，主要靠left++ 完成
            while (count == targetCount) {
                // 获取最左边的字符
                currChar = s.charAt(left);
                // 当需要删除的字符串，是必须留在窗口时
                if (needs[currChar] > 0 && needs[currChar] >= window[currChar]) {
                    count--;
                }
                // 如果出现了最小值，就做一个替换操作
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                window[currChar]--;
                // left 右移一位
                left++;
            }
            //right 右移
            right++;
        }
        return res;
    }

    public String minWindow4(String s, String t) {
        String result = "";
        int sLength;
        // 需要匹配子串的长度；
        int tLength;
        if (s == null || t == null || (sLength = s.length()) == 0 ||
                (tLength = t.length()) == 0 || sLength < tLength) {
            return result;
        }
        int targetCount = tLength;
        int[] needs = new int[128];
        int[] windows = new int[128];
        for (char c : t.toCharArray()) {
            needs[c]++;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int minLength = sLength + 1;
        while (right < sLength) {
            char currChar = s.charAt(right);
            // 将当前字符添加到窗口里，并记录出现次数
            windows[currChar]++;
            // 如果当前字符在needs和窗口里都有，那么count就+1；
            if (needs[currChar] > 0 && needs[currChar] >= windows[currChar]) {
                count++;
            }
            // 开始监听count,
            while (count == targetCount) {
                //  right  不动，left 开始往右边移动
                currChar = s.charAt(left);
                // 当前的字符在needs和window中都存在
                if (needs[currChar] > 0 && needs[currChar] >= windows[currChar]) {
                    count--;
                }
                // 如果存在最小区间，就做一下替换
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                windows[currChar]--;
                // 坐指针右移，缩小范围
                left++;
            }

            // 为了右移
            right++;
        }

        return result;

    }

    public String minWindow5(String s, String t) {
        String result = "";
        int sLength;
        int tLength;
        if (s == null || t == null || (sLength = s.length()) == 0
                || (tLength = t.length()) == 0 || sLength < tLength) {
            return result;
        }
        int targetCount = tLength;
        int minLength = sLength + 1;
        int[] needs = new int[128];
        int[] windows = new int[128];
        for (char c : t.toCharArray()) {
            needs[c]++;
        }

        int left = 0;
        int right = 0;
        int count = 0;
        while (right < sLength) {
            char currChar = s.charAt(right);
            windows[currChar]++;
            if (needs[currChar] > 0 && needs[currChar] >= windows[currChar]) {
                count++;
            }
            while (count == targetCount) {
                currChar = s.charAt(left);
                if (needs[currChar] > 0 && needs[currChar] >= windows[currChar]) {
                    count--;
                }
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                windows[currChar]--;
                left++;
            }

            right++;
        }
        return result;
    }

    public String minWindow6(String s, String t) {
        String result = "";
        int sLen;
        int tLen;
        if (s == null || t == null || (sLen = s.length()) == 0 || (tLen = t.length()) == 0 || sLen < tLen) {
            return result;
        }

        int targetCount = tLen;
        int count = 0;
        int[] needs = new int[128];
        int[] window = new int[128];
        int left = 0;
        int right = 0;
        int minLength = sLen + 1;
        for (char c : t.toCharArray()) {
            needs[c]++;
        }
        while (right < sLen) {
            char currChar = s.charAt(right);
            window[currChar]++;
            if (needs[currChar] > 0 && needs[currChar] >= window[currChar]) {
                count++;
            }

            while (count == targetCount) {
                currChar = s.charAt(left);
                if (needs[currChar] > 0 && needs[currChar] >= window[currChar]) {
                    count--;
                }
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                window[currChar]--;
                left++;
            }

            right++;
        }

        return result;

    }

    public String minWindow7(String s, String t) {
        String result = "";
        int sLen;
        int tLen;
        if (s == null || t == null || (sLen = s.length()) == 0 || (tLen = t.length()) == 0 || sLen < tLen) {
            return result;
        }
        int targetCount = tLen;
        int count = 0;
        int[] needs = new int[128];
        int[] window = new int[128];
        int left = 0;
        int right = 0;
        int minLength = sLen + 1;
        for (char c : t.toCharArray()) {
            needs[c]++;
        }

        while (right < sLen) {
            char currChar = s.charAt(right);
            if (needs[currChar] > 0 && needs[currChar] >= window[currChar]) {
                count++;
            }

            while (count == targetCount) {
                currChar = s.charAt(left);
                if (needs[currChar] > 0 && needs[currChar] >= window[currChar]) {
                    count--;
                }
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                window[currChar]--;
                left++;
            }
            right++;
        }
        return result;
    }

}
