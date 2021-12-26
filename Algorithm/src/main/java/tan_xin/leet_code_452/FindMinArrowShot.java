package tan_xin.leet_code_452;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/26 23:29
 * @Url : https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * @Level :    medium
 * @Desc : 用最少数量的箭，引爆气球；
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/solution/chuan-shang-yi-fu-wo-jiu-bu-ren-shi-ni-liao-lai-3/
 * <p>
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/solution/yong-zui-shao-shu-liang-de-jian-yin-bao-qi-qiu-tu-/
 */
public class FindMinArrowShot {
    public int findMinArrowShots(int[][] points) {
        //边界条件判断
        if (points == null || points.length == 0)
            return 0;
        //按照每个气球的右边界排序
        Arrays.sort(points, (a, b) -> a[1] > b[1] ? 1 : -1);
        //获取排序后第一个气球右边界的位置，我们可以认为是箭射入的位置
        int last = points[0][1];
        //统计箭的数量
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            //如果箭射入的位置小于下标为i这个气球的左边位置，说明这支箭不能
            //击爆下标为i的这个气球，需要再拿出一支箭，并且要更新这支箭射入的
            //位置
            if (last < points[i][0]) {
                last = points[i][1];
                count++;
            }
        }
        return count;


    }

}
