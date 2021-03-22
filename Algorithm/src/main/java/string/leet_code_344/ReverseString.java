package string.leet_code_344;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/19 17:18
 * @Desc : 344: 反转字符串  (https://leetcode-cn.com/problems/reverse-string/)
 */
public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
//        char [] raws = {'h','e','l','l','o'};
        char[] raws = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString.reverseString1(raws);
        System.out.println("result: " + Arrays.toString(raws));
    }

    public void reverseString1(char[] s) {
        int i = 0;
        int j = s.length - 1;
        // 记住啊，，一定要用小于号做判断
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public void reverseString2(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i]= s[j];
            s[i] = temp;
            i++;
            j--;
        }
    }


}
