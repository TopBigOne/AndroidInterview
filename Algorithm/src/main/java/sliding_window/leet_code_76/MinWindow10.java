package sliding_window.leet_code_76;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/24 22:40
 * @Desc :
 */
public class MinWindow10 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinWindow10 window = new MinWindow10();
        String result = window.minWindow(s, t);
        //  assert Objects.equals(result, "BANC");
        System.err.println("result : " + result);
    }

    public String minWindow(String s, String t) {

        int[] needs = new int[256];
        int[] windows = new int[256];
        int left = 0;
        int right = 0;
        int sLength = s.length();
        int tLength = t.length();
        int minLength = sLength + 1;

        String res = "";


        int count = 0;
        for (char c : t.toCharArray()) {
            needs[c]++;
        }
        while (right < sLength) {
            char rightChar = s.charAt(right);
            windows[rightChar]++;

            // needs[rightChar]: 说明有这个字符；
            // needs[rightChar] > windows[rightChar]: 说明这个字符，在windows 的数量
            // 还没有达到needs中的数量
            if (needs[rightChar] > 0 && needs[rightChar] >= windows[rightChar]) {
                count++;
            }
            while (count == tLength) {
                char leftChar = s.charAt(left);
                if (needs[leftChar] > 0 && needs[leftChar] >= windows[leftChar]) {
                    count--;
                }

                if (right - left + 1 < minLength) {
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
