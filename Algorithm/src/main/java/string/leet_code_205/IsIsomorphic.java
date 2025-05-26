package string.leet_code_205;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2022/11/14 22:19
 * @Desc :https://leetcode.cn/problems/isomorphic-strings/solutions/60994/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-42/?orderBy=most_votes
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        int[] mapOne = new int[128];
        int[] mapTwo = new int[128];
        for (int i = 0; i < length; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            // 当前的映射是否相等
            if (mapOne[c1] != mapTwo[c2]) {
                return false;
            } else {
                if (mapOne[c1] == 0) {
                    mapOne[c1] = i + 1;
                    mapTwo[c2] = i + 1;
                }

            }
        }
        return true;


    }


}
