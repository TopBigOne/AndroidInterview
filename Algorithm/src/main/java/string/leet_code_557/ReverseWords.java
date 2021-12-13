package string.leet_code_557;

import java.io.StringReader;
import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  12/13/21 8:36 PM
 * @Desc :
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        // String s = "chen xiao ya";
        ReverseWords reverseWords = new ReverseWords();
        String result = reverseWords.reverseWords(s);
        System.out.println("result :" + result);

    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(reverseChar(word)).append(" ");
        }
        return sb.toString().trim();
    }

    private String reverseChar(String word) {
        StringBuilder sb = new StringBuilder(word);
        sb.reverse();
        System.out.println("sb  ：" + sb.toString());
        return sb.toString();
    }


}
