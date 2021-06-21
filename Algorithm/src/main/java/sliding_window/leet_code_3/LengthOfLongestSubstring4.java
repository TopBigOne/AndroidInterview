package sliding_window.leet_code_3;

/**
 * @author : dev
 * @version :
 * @Date :  5/23/21 1:25 PM
 * @Desc : https://www.youtube.com/watch?v=EbemoR4LooA&t=137s
 */
public class LengthOfLongestSubstring4 {


    public static void main(String[] args) {
        LengthOfLongestSubstring4 lengthOfLongestSubstring4 = new LengthOfLongestSubstring4();
//        String raw = "pwwkew";
        String raw = "abbcdeb";
        int result = lengthOfLongestSubstring4.lengthOfLongestSubstring(raw);
        System.out.println("result: " + result);


    }

    public int lengthOfLongestSubstring(String s) {
        int length;
        if (s == null || (length = s.length()) == 0) {
            return 0;
        }
        int result = 0;
        int[] map = new int[256];
        int start = 0;
        for (int i = 0; i < length; i++) {
            // a: asc 表，是 97，
            char currChar = s.charAt(i);
            map[currChar]++;
            while (map[currChar] > 1) {
                char startChar = s.charAt(start);
                map[startChar]--;
                start++;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }

    public int lengthOfLongSubstring(String s) {
        int length;
        if (s == null || (length = s.length()) == 0) {
            return 0;
        }
        int result = 0;
        // 字符频数数组
        int[] map = new int[256];
        int start = 0;
        for (int i = 0; i < length; i++) {
            char currChar = s.charAt(i);
            map[currChar]++;
            // 检索一下；
            while (map[currChar] > 1) {
                char startChar = s.charAt(start);
                map[startChar]--;
                start++;
            }

            result = Math.max(result, i - start + 1);
        }

        return result;
    }


}
