package sliding_window.leet_code_76;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/21 10:44
 * @Url : https://leetcode-cn.com/problems/minimum-window-substring/
 * @Level :     hard
 * @Desc :  leetcode 76 ：最小覆盖子串，困难，字节：26 次：
 * @Counter :
 * @Answer :
 */
public class MinWindow4 {
    public String minWindow(String s, String t) {
        String res = "";
        int sLength = s.length();
        int tLength = t.length();
        int[] needs = new int[128];
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
            window[currChar]++;

            if (needs[currChar] > 0 && needs[currChar] >= window[currChar]) {
                count++;
            }
            while (count == tLength) {
                currChar = s.charAt(left);
                if (needs[currChar] > 0 && needs[currChar] >= window[currChar]) {
                    count--;
                }

                if (right - left + 1 <= minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                window[currChar]--;
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
                if (needs[currChar] > 0 && needs[currChar] >= windows[currChar]) {
                    count--;
                }
                if (right - left + 1 < minLength) {
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
