package sliding_window.leet_code_76;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/28 18:20
 * @Url :
 * @Level :     hard
 * @Desc : 最小覆盖子串
 * @Counter :
 * @Answer :
 */
public class MinWindow6 {
    public String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int count = 0;
        int[] needs = new int[256];
        int[] windows = new int[256];
        String res = "";
        int minLength = sLength + 1;
        int left = 0;
        int right = 0;
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
                left++;
                windows[leftChar]--;
            }
            right++;
        }
        return res;
    }
}
