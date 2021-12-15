package sliding_window.leet_code_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  12/15/21 10:13 PM
 * @Desc : https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/solution/shua-chuan-lc-po-su-ha-xi-biao-jie-fa-hu-ml3x/
 */
public class FindSubstring {



    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words.length == 0) return ans;

        int n = s.length(), m = words.length, w = words[0].length();

        // 统计 words 中「每个目标单词」的出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < w; i++) {
            // 构建一个当前子串对应 map，统计当前子串中「每个目标单词」的出现次数
            Map<String, Integer> curMap = new HashMap<>();
            // 滑动窗口的大小固定是 m * w
            // 每次将下一个单词添加进 cur，上一个单词移出 cur
            for (int j = i; j + w <= n; j += w) {
                String cur = s.substring(j, j + w);
                if (j >= i + (m * w)) {
                    int idx = j - m * w;
                    String prev = s.substring(idx, idx + w);
                    if (curMap.get(prev) == 1) {
                        curMap.remove(prev);
                    } else {
                        curMap.put(prev, curMap.get(prev) - 1);
                    }
                }
                curMap.put(cur, curMap.getOrDefault(cur, 0) + 1);
                // 如果当前子串对应 map 和 words 中对应的 map 相同，说明当前子串包含了「所有的目标单词」，将起始下标假如结果集
                if (map.containsKey(cur) && curMap.get(cur).equals(map.get(cur)) && cmp(map, curMap)) {
                    ans.add(j - (m - 1) * w);
                }
            }
        }

        return ans;
    }

    // 比较两个 map 是否相同
    boolean cmp(Map<String, Integer> m1, Map<String, Integer> m2) {
        if (m1.size() != m2.size()) return false;
        for (String k1 : m1.keySet()) {
            if (!m2.containsKey(k1) || !m1.get(k1).equals(m2.get(k1))) return false;
        }
        for (String k2 : m2.keySet()) {
            if (!m1.containsKey(k2) || !m1.get(k2).equals(m2.get(k2))) return false;
        }
        return true;
    }




}
