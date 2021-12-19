package sliding_window.leet_code_1610;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/16 23:28
 * @Url :https://leetcode-cn.com/problems/maximum-number-of-visible-points/
 * @Level :   hard
 * @Desc : 可见点的最大数目
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/maximum-number-of-visible-points/solution/gong-shui-san-xie-qiu-ji-jiao-ji-he-ti-b-0bid/
 */
public class VisiblePoints {
    double eps = 1e-9;

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int x = location.get(0), y = location.get(1);
        List<Double> list = new ArrayList<>();
        int cnt = 0;
        double pi = Math.PI, t = angle * pi / 180;
        for (List<Integer> p : points) {
            int a = p.get(0), b = p.get(1);
            if (a == x && b == y && ++cnt >= 0) continue;
            list.add(Math.atan2(b - y, a - x) + pi);
        }
        Collections.sort(list);
        int n = list.size(), max = 0;
        for (int i = 0; i < n; i++) list.add(list.get(i) + 2 * pi);
        for (int i = 0, j = 0; j < 2 * n; j++) {
            while (i < j && list.get(j) - list.get(i) > t + eps) i++;
            max = Math.max(max, j - i + 1);
        }
        return cnt + max;
    }


}
