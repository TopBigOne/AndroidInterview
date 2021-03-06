package array.leet_code_911;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/11 23:35
 * @Url :https://leetcode-cn.com/problems/online-election/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :  https://leetcode-cn.com/problems/online-election/solution/gong-shui-san-xie-er-fen-yun-yong-ti-by-5y3hi/
 */
public class TopVotedCandidate {

    List<int[]> list = new ArrayList<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        int val = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if (map.get(persons[i]) >= val) {
                val = map.get(persons[i]);
                list.add(new int[]{times[i], persons[i]});
            }
        }
    }

    public int q(int t) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (list.get(mid)[0] <= t) l = mid;
            else r = mid - 1;
        }
        return list.get(r)[0] <= t ? list.get(r)[1] : 0;
    }


}
