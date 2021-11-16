package sliding_window.leet_code_187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author : dev
 * @version :
 * @Date :  11/2/21 10:08 PM
 * @Desc :https://leetcode-cn.com/problems/repeated-dna-sequences/
 */
public class FindRepeatedDnaSequences {
    /**
     * 滑动窗口+ hash 表
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= n; i++) {
            String curr = s.substring(i, i + 10);
            int cnt = map.getOrDefault(curr, 0);
            if (cnt == 1) {
                ans.add(curr);
            }
            map.put(curr, cnt + 1);
        }
        return ans;

    }

    int N = (int) 1e5 + 10, P = 131313;
    int[] h = new int[N];
    int[] p = new int[N];

    /**
     * 字符串 hash+ 前缀和
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences2(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + s.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i + 10 - 1 <= n; i++) {
            int j = i + 10 - 1;
            int hash = h[j] - h[i - 1] * p[j - i + 1];
            int cnt = map.getOrDefault(hash, 0);
            if (cnt == 1) {
                ans.add(s.substring(i - 1, i + 10 - 1));
            }
            map.put(hash, cnt + 1);
        }
        return ans;

    }
}
