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
    public static void main(String[] args) {
        MinWindow4 minWindow = new MinWindow4();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow.minWindow3(s, t);
        System.err.println("result : " + result);

    }

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

                int tempLength = right - left + 1;
                if (tempLength <= minLength) {
                    minLength = tempLength;
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

    public String minWindow3(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[] needs = new int[256];
        int[] windows = new int[256];
        int minLength = sLength;
        int left = 0;
        int right = 0;
        String res = "";
        int count = 0;
        for (char c : t.toCharArray()) {
            needs[c]++;
        }

        while (right < sLength) {
            char rightChar = s.charAt(right);
            windows[rightChar]++;
            if (needs[rightChar] > 0 && windows[rightChar] <= needs[rightChar]) {
                count++;
            }
            while (count == tLength) {
                char leftChar = s.charAt(left);
                if (needs[leftChar] > 0 && windows[leftChar] <= needs[leftChar]) {
                    count--;
                }

                // 当两个串相等时，也做一下截取！
                if (right - left + 1 <= minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                windows[leftChar]--;
                left++;
            }

            right++;
        }


        return res;


    }
}
