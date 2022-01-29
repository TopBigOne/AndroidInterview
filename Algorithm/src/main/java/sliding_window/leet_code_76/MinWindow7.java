package sliding_window.leet_code_76;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/29 17:29
 * @Url :
 * @Level :   hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class MinWindow7 {
    public String minWindow(String s, String t) {
        int tLength = t.length();
        int sLength = s.length();
        int count = 0;
        int minLength = sLength + 1;
        int[] needs = new int[256];
        int[] windows = new int[256];
        int left = 0;
        int right = 0;
        String res = "";
        for (char c : t.toCharArray()) {
            needs[c]++;
        }

        while (right < sLength) {
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
