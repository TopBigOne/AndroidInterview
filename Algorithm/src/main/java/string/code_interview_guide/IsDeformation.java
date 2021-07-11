package string.code_interview_guide;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  5/23/21 1:04 AM
 * @Desc :   判断两个字符串是否为变形词
 */
public class IsDeformation {
    public boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        char[] charsOne = str1.toCharArray();
        char[] charsTow = str2.toCharArray();
        int[] map = new int[256];
        for (char c : charsOne) {
            map[c]++;
        }
        System.out.println("map : " + Arrays.toString(map));
        for (char c : charsTow) {
            if (map[c]-- == 0) {
                return false;
            }
        }

        int a = 10;
        return true;

    }


    public boolean isDeformation2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        char[] charsOne = str1.toCharArray();
        char[] charsTow = str2.toCharArray();
        Map<Character, Integer> map = new HashMap<>(256);
        for (char c : charsOne) {
            map.put(c, map.getOrDefault(c, 0) + 1);

        }
        System.out.println("map : " + map);
        for (char c : charsTow) {
            if (map.containsKey(c)) {
                Integer integer = map.get(c);
                map.put(c, integer - 1);
            }
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (characterIntegerEntry.getValue() != 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "213";
        IsDeformation isDeformation = new IsDeformation();
        boolean result = isDeformation.isDeformation2(str1, str2);
        System.out.println("result0 : " + result);

    }
}
