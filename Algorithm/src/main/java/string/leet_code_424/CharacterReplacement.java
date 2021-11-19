package string.leet_code_424;

import java.util.Currency;

import javax.swing.text.AbstractDocument;

import sun.tools.tree.NewInstanceExpression;

/**
 * @author : dev
 * @version :
 * @Date :  11/19/21 9:16 PM
 * @Desc :  https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/hua-dong-chuang-kou-chang-gui-tao-lu-by-xiaoneng/
 * <p>
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/6ms-chao-guo-90-by-xuanyuan-4/
 */
public class CharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        CharacterReplacement replacement = new CharacterReplacement();

    }

    public int characterReplacement(String s, int k) {
        int result = 0;
        int maxCount = 0;
        int[] count = new int[26];
        char a = 'A';

        for (int right = 0, left = 0; right < s.length(); right++) {
            // 当前窗口内的最多字符的个数
            maxCount = Math.max(maxCount, ++count[s.charAt(right) - a]);

            // 需要替换的字符个数就是当前窗口的大小减去窗口中数量最多的字符的数量
            while (k + maxCount < right - left + 1) {
                count[s.charAt(left) - a]--;
                //缩小窗口
                left++;
            }
            // 当窗口内可替换的字符数小于等于k时，我们需要根据该窗口长度来确定是否更新result
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public int characterReplacement2(String s, int k) {
        int result = 0;
        int maxCount = 0;
        int[] charCcout = new int[26];
        char a = 'A';
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            // 窗口内的最多字符的个数
            maxCount = Math.max(maxCount, ++charCcout[currChar - a]);
            // 需要替换的字符个数就是当前窗口的大小减去窗口中数量最多的字符的数量
            while (k + maxCount < right - left + 1) {
                charCcout[s.charAt(left) - a]--;
                // 缩小窗口
                left++;
            }
            // 当窗口内可替换的字符数小于等于 k 时，我们需要根据窗口长度来确定是否更新 result
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public int characterReplacement3(String s, int k) {
        int result = 0;
        int maxCountt = 0;
        int[] charCountArray = new int[26];
        // 大 A 字符，做减法使用
        char a = 'A';
        // 左边窗口边界
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            maxCountt = Math.max(maxCountt, ++charCountArray[currChar - a]);
            while (k + maxCountt < right - left + 1) {
                charCountArray[s.charAt(left) - a]--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public int characterReplacement4(String s, int k) {
        int result = 0;
        int maxCount = 0;
        int[] charCountArray = new int[26];
        char a = 'A';
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            maxCount = Math.max(maxCount, ++charCountArray[currChar - a]);
            while (k + maxCount < right - left + 1) {
                charCountArray[s.charAt(left) - a]--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public int characterReplacement5(String s, int k) {
        int result = 0;
        int maxCount = 0;
        int[] charCountArray = new int[26];
        char a = 'A';
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);

            maxCount = Math.max(maxCount, ++charCountArray[currChar - a]);

            while (maxCount + k < right - left + 1) {
                charCountArray[s.charAt(left) - a]--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;

    }

    public int characterReplacement6(String s, int k) {
        int length = s.length();
        int[] charCount = new int[26];
        int left = 0;
        int result = 0;
        int maxCount = 0;
        char a = 'A';

        for (int right = 0; right < length; right++) {
            char c = s.charAt(right);
            maxCount = Math.max(maxCount, ++charCount[c - a]);
            while (maxCount + k < right - left + 1) {
                charCount[s.charAt(left) - a]--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public int characterReplacement7(String s, int k) {
        int length = s.length();
        int[] charCount = new int[26];
        int left = 0;
        int result = 0;
        int maxCount = 0;
        char a = 'A';
        for (int right = 0; right < length; right++) {
            char c = s.charAt(right);
            maxCount = Math.max(maxCount, ++charCount[c - a]);
            while (maxCount + k < right - left + 1) {
                charCount[s.charAt(left) - a]--;
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
