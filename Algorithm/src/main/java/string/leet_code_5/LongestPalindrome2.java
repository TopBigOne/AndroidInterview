package string.leet_code_5;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/28 17:39
 * @Desc : 最长回文子串
 */
public class LongestPalindrome2 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String str = "I love C++";
        String[] split = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]).append(" ");
        }
        String newStr = sb.toString().trim();
        System.out.println("result : " + newStr);

    }
}
