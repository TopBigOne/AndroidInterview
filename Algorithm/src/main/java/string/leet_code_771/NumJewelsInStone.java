package string.leet_code_771;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2022/11/13 23:50
 * @Desc :
 */
public class NumJewelsInStone {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        int ans = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                ans++;
            }
        }
        return ans;
    }


}
