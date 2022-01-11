package sliding_window.leet_code_76;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/20 21:19
 * @Url :
 * @Level :     hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class MinWindow3 {
    public String minWindow(String s, String t) {
        String res = "";
        int sLength;
        int tLength;
        // corner base
        if (s == null || t == null || (sLength = s.length()) == 0 || (tLength = t.length()) == 0) {
            return res;
        }
        // 用来统计t中每个字符出现的次数
        int[] needs = new int[128];
        //  用来统计滑动窗口中每个字符出现的次数
        int[] window = new int[128];


        for (char c : t.toCharArray()) {
            needs[c]++;
        }

        int left = 0;
        int right = 0;
        // 目前有多少个字符
        int count = 0;
        //
        int minLength = sLength + 1;
        while (right < sLength) {
            char ch = s.charAt(right);
            window[ch]++;
            // 如果需要该字符，并且窗口内的字符个数小于 需要的字符个数
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;
            }
            // 当需要的字符数都已经包含在窗口中，开始收缩left
            while (count == tLength) {
                ch = s.charAt(left);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    count--;
                }
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


    public String minWindow2(String s, String t) {
        String res = "";
        int sLength = s.length();
        int tLength = t.length();
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
            windows[currChar]++;
            if (needs[currChar] > 0 && needs[currChar] >= windows[currChar]) {
                count++;
            }
            while (count == tLength) {
                currChar = s.charAt(left);
                // 当需要删除的字符串，是必须留在窗口时
                if (needs[currChar] > 0 && needs[currChar] >= windows[currChar]) {
                    count--;
                }
                if (right - left + 1 <= minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);

                }
                windows[currChar]--;
                left++;
            }
            right++;
        }
        return res;


    }
}
