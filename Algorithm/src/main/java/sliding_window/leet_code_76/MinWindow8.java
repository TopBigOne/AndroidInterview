package sliding_window.leet_code_76;

/**
 * @author : dev
 * @version :
 * @Date :  2022/3/7 17:19
 * @Desc : 最小覆盖子串
 */
public class MinWindow8 {

    public static void main(String[] args) {
        // s = "ADOBECODEBANC", t = "ABC"
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinWindow8 minWindow = new MinWindow8();
        String resut = minWindow.minWindow(s, t);
        boolean testResult = resut == "BANC";
        System.out.println("testResult :" + testResult);

    }


    public String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[] needs = new int[256];
        int[] windows = new int[256];
        int count = 0;
        int minLength = s.length() + 1;
        int left = 0;
        int right = 0;
        String result = "";
        for (char c : t.toCharArray()) {
            needs[c]++;
        }

        while (right < sLength) {
            char rightChar = s.charAt(right);
            windows[rightChar]++;
            if (needs[rightChar] > 0 && needs[rightChar] >= windows[rightChar]) {
                count++;
            }
            while (count == tLength) {
                char leftChar = s.charAt(left);
                if (needs[leftChar] > 0 && needs[leftChar] >= windows[leftChar]) {
                    count--;
                }


                int tempLength = right - left + 1;
                if (tempLength < minLength) {
                    minLength = tempLength;
                    result = s.substring(left, right + 1);
                }

                left++;
                windows[leftChar]--;
            }

            right++;
        }
        return result;
    }
}
