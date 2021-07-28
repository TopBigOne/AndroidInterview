package sliding_window.leet_code_904;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  7/27/21 1:23 AM
 * @Desc : leet-code 904 : 水果成篮: https://leetcode-cn.com/problems/fruit-into-baskets/
 * 题解：https://leetcode-cn.com/problems/fruit-into-baskets/solution/zhong-gui-zhong-ju-bo-diao-ma-jia-gai-ti-ben-zhi-j/
 */
public class TotalFruit {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) return 0;

        int length = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();

        int maxLen = 0;
        int left = 0;

        for (int i = 0; i < length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;

    }
}
