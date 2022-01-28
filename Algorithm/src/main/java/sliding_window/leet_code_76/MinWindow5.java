package sliding_window.leet_code_76;

/**
 * @author : dev
 * @version :
 * @Date :  1/11/22 8:12 PM
 * @Desc :
 */
public class MinWindow5 {

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
        int[] need = new int[128];
        int[] window = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int minLength = sLength + 1;

        while (right < sLength) {
            char currChar = s.charAt(right);
            window[currChar]++;
            if (need[currChar] > 0 && need[currChar] >= window[currChar]) {
                count++;
            }
            while (count == tLength) {
                currChar = s.charAt(left);
                if (need[currChar] > 0 && need[currChar] >= window[currChar]) {
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

    public String minWindow3(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[] needs = new int[256];
        int[] windows = new int[256];
        int left = 0;
        int right = 0;
        int minLength = sLength + 1;
        String res = "";
        int count = 0;
        for (char c : t.toCharArray()) {
            needs[c]++;
        }

        while (right < minLength) {
            char currChar = s.charAt(right);
            windows[currChar]++;

            if (needs[currChar] > 0 && needs[currChar] >= windows[currChar]) {
                count++;
            }
            while (count == tLength) {
                char leftChar = s.charAt(left);
                if (needs[leftChar] > 0 && needs[leftChar] >= windows[leftChar]) {
                    count--;
                }

                int tempLength = right - left + 1;
                if (tempLength <= minLength) {
                    minLength = tempLength;
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
