package sliding_window.leet_code_76;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 16:35
 * @Desc :
 */
public class MinWindow11 {
    public static void main(String[] args) {
        MinWindow11 minWindow = new MinWindow11();
        String s = "ADOBECODEBANC", t = "ABC";
        String result = minWindow.minWindow(s, t);
        System.err.println("result  : " + result);


    }

    /**
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[] window = new int[128];
        int[] need = new int[128];
        int count = 0;
        int minLength = sLength + 1;
        int start = 0;
        int end = 0;
        String res = "";

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        while (end < sLength) {
            char currChar = s.charAt(end);
            window[currChar]++;
            if (need[currChar] > 0 && window[currChar] <= need[currChar]) {
                count++;
            }
            while (count == tLength) {
                char startChar = s.charAt(start);
                if (need[startChar] > 0 && window[startChar] <= need[startChar]) {
                    count--;
                }

                int temp = end - start + 1;
                if (temp < minLength) {
                    minLength = temp;
                    res = s.substring(start, end + 1);
                }

                start++;
                window[startChar]--;

            }

            end++;
        }
        return res;

    }
}
