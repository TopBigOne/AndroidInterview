package hash.offer_50;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/27 17:37
 * @Desc :   第一个只出现一次的字符
 * https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "adacacbehff";
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println("raw string : " + s);
        char result = firstUniqChar.firstUniqChar(s);
        System.err.println("result : " + result);
    }

    /**
     * @param s "adaccbehff"
     * @return
     */
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new HashMap<>();
        // 按照put
        for (char c : s.toCharArray()) {
            // 不包含字符，就说明是第一次put
            boolean isNotContain = !dic.containsKey(c);
            dic.put(c, isNotContain);
            System.out.println("dic : " + dic);

        }
        // 按照顺序取： 状态
        for (char c : s.toCharArray()) {
            // 第一个为true 的就是结果
            if (dic.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    public char firstUniqChar2(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            boolean status = map.containsKey(c);
            if (!status) {
                map.put(c, true);
            } else {
                map.put(c, false);
            }
        }
        for (char c : s.toCharArray()) {
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';


    }
}
