package map.leet_code_290;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/10/20 23:37
 * @Url : https://leetcode.cn/problems/word-pattern/description/?orderBy=hot
 * @Level :  easy
 * @Desc : 290. 单词规律
 * @Counter :
 * @Answer :
 */
public class WordPattern2 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int len = words.length;
        if (len != pattern.length()) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < len; i++) {
            if (map.put(words[i], i) != map.put(pattern.charAt(i), i)) {
                return false;
            }
        }
        return true;

    }
}
