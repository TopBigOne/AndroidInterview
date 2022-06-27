package string.leet_code_387;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :   2022/6/27 00:55
 * @Desc : 387. 字符串中的第一个唯一字符 :  https://leetcode.cn/problems/first-unique-character-in-a-string/
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        String s = "loveleetcode";
        int result = firstUniqChar.firstUniqChar(s);
        System.err.println("result : " + result);
    }

    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
        }
        char targetChar = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                targetChar = entry.getKey();
                break;
            }
        }
        if (targetChar == ' ') {
            return -1;
        }
        return s.indexOf(targetChar);

    }

    public int firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        int[] map = new int[256];
        for (char aChar : chars) {
            map[aChar]++;
        }

        for (char aChar : chars) {
            if (map[aChar] == 1) {
                return s.indexOf(aChar);
            }
        }
        return -1;

    }
}
