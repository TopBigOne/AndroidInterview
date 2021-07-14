package string.leet_code_5;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/14 22:21
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class LongestPalindrome3 {
    public String longestPalindrome(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return "";
        }

        int start = 0;
        int end = 0;


        for (int i = 0; i < len; i++) {
            int len1 = expandAroundCenter(s,len,i,i);
            int len2 = expandAroundCenter(s,len,i,i+1);

            int maxLen = Math.max(len1,len2);


        }

    }


}
