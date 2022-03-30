package sliding_window.leet_code_76;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/3/30 13:42
 * @Url :
 * @Level :     hard
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/minimum-window-substring/solution/hua-dong-chuang-kou-ji-bai-liao-100de-javayong-hu-/
 */
public class MinWindow9 {

    public String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[] needs = new int[256];
        int[] window = new int[256];
        String res = "";
        int minLength = sLength + 1;
        int left = 0;
        int right = 0;
        int count = 0;

        for (char c : t.toCharArray()) {
            needs[c]++;
        }

        while (right < sLength) {
            char currChar = s.charAt(right);
            window[currChar]++;
            if (needs[currChar] > 0 && needs[currChar] >= window[currChar]) {
                count++;
            }
            while (count == tLength) {
                char leftChar = s.charAt(left);
                if (needs[leftChar] > 0 && needs[leftChar] >= window[leftChar]) {
                    count--;
                }
                int tempLength = right - left + 1;
                if (tempLength <= minLength) {
                    minLength = tempLength;
                    res = s.substring(left, right + 1);
                }

                window[leftChar]--;
                left++;

            }
            right++;
        }

        return res;

    }
}
