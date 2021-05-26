package string.leet_code_14;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/26 20:32
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String result = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println("result : "+result);

    }
}
