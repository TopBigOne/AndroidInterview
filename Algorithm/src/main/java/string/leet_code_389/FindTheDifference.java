package string.leet_code_389;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/10/25 19:00
 * @Url : https://leetcode.cn/problems/find-the-difference/
 * @Level :  easy
 * @Desc : 389. 找不同
 * @Counter :
 * @Answer :
 */
public class FindTheDifference {
    public static void main(String[] args) {
        FindTheDifference findTheDifference = new FindTheDifference();
        String s = "abcd";
        String t = "abcde";
        char theDifference = findTheDifference.findTheDifference(s, t);
        System.err.println("theDifference : " + theDifference);
    }

    public char findTheDifference(String s, String t) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return c;
            }
        }
        return ' ';

    }

    public char findTheDifference2(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return c;
            }

        }
        return ' ';

    }

}
