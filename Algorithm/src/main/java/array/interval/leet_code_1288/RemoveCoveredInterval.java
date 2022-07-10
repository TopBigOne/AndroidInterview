package array.interval.leet_code_1288;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/10 04:15
 * @Desc :
 * <p>
 * 题解：https://leetcode.cn/problems/remove-covered-intervals/solution/sao-miao-xian-fa-by-liweiwei1419/
 */
public class RemoveCoveredInterval {
    public static void main(String[] args) {
        // int[][] interval = {{3, 10}, {4, 10}, {5, 11}};
        int[][] interval = {{1, 2}, {1, 4}, {3, 4}};
        RemoveCoveredInterval removeCoveredInterval = new RemoveCoveredInterval();
        int result = removeCoveredInterval.removeCoveredIntervals(interval);
        System.err.println("result : " + result);
    }

    public int removeCoveredIntervals(int[][] intervals) {
        int len = intervals.length;
        // 特判
        if (len < 2) {
            return len;
        }

        // 特别注意：当区间左端点相同的时候，右端点降序排序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        System.err.println("intervals after sort : " + Arrays.deepToString(intervals));

        // 需要被删除的区间个数
        int remove = 0;
        int preRight = intervals[0][1];
        for (int i = 1; i < len; i++) {
            int currRight = intervals[i][1];
            if (currRight <= preRight) {
                remove++;
            } else {
                preRight = currRight;
            }
        }
        return len - remove;

    }


    public int removeCoveredIntervals2(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        int remove = 0;
        int preRight = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][1] <= preRight) {
                remove++;
            } else {
                preRight = intervals[i][1];
            }
        }
        return len - remove;


    }
}
