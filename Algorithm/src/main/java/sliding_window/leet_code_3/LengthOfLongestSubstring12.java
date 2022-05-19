package sliding_window.leet_code_3;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/18 13:29
 * @Desc :
 */
public class LengthOfLongestSubstring12 {

    public static void main(String[] args) {
        LengthOfLongestSubstring12 lengthOfLongestSubstring = new LengthOfLongestSubstring12();
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring(s);
        System.out.println("result : " + result);
    }

    public int lengthOfLongestSubstring(String s) {
        int[] window = new int[256];
        int left = 0;
        int right = 0;
        int len = s.length() - 1;// -1 需要做一个check
        int maxLength = 0;
        while (right < len) {
            char rightChar = s.charAt(right);
            window[rightChar]++;

            while (window[rightChar] > 1) {
                char leftChar = s.charAt(left);
                window[leftChar]--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;


    }
}
