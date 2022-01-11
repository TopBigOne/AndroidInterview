package array.leet_code_846;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author : dev
 * @version :
 * @Date :  12/30/21 6:52 PM
 * @Desc :
 * <p>
 * 一手顺子
 * <p>
 * https://leetcode-cn.com/problems/hand-of-straights/
 */
public class IsNStraightHand {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            q.add(i);
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            if (map.get(t) == 0) continue;
            for (int i = 0; i < groupSize; i++) {
                int cnt = map.getOrDefault(t + i, 0);
                if (cnt == 0) return false;
                map.put(t + i, cnt - 1);
            }
        }
        return true;


    }
}
