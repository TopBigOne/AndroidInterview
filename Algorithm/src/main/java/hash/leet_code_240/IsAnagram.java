package hash.leet_code_240;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/31 19:56
 * @Url : https://leetcode-cn.com/problems/valid-anagram/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/valid-anagram/solution/hua-jie-suan-fa-242-you-xiao-de-zi-mu-yi-wei-ci-by/
 */
public class IsAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        doSort(s, t);

        test1();


    }

    private static void test1() {
        String s = "anagram", t = "nagaram";
        IsAnagram isAnagram = new IsAnagram();

        isAnagram.isAnagram(s, t);


    }

    private static void doSort(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        System.out.println(s1);
        System.out.println(t1);

    }

    public boolean isAnagram(String s, String t) {
        int sLength = 0;
        int tLength = 0;
        if ((sLength = s.length()) != (tLength = t.length())) {
            return false;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < sLength; i++) {
            int left = s.charAt(i) - 'a';
            int right = t.charAt(i) - 'a';
            alpha[left]++;
            alpha[right]--;

        }
        for (int j = 0; j < 26; j++) {
            if (alpha[j] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        if (sLength != tLength) return false;
        int[] alpha = new int[26];
        for (int i = 0; i < sLength; i++) {
            int left = s.charAt(i) - 'a';
            int right = t.charAt(i) - 'a';
            alpha[left]++;
            alpha[right]--;
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i] != 0) return false;
        }
        return true;
    }


}
