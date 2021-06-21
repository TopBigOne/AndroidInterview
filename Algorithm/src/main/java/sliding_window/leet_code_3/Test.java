package sliding_window.leet_code_3;

/**
 * @author : dev
 * @version :
 * @Date :  5/22/21 5:18 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        String raw = "abcabcbb";
        LengthOfLongestSubstring3 lengthOfLongestSubstring3 = new LengthOfLongestSubstring3();
        int result = lengthOfLongestSubstring3.lengthOfLongestSubstring4(raw);
        System.out.println("result : "+result);
    }
}
