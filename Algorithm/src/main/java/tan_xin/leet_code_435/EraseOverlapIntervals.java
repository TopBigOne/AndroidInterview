package tan_xin.leet_code_435;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/11/9 20:36
 * @Url : https://leetcode.cn/problems/non-overlapping-intervals/
 * @Level :    medium
 * @Desc : 无重复区间：贪心算法
 * @Counter :
 * @Answer :
 * https://leetcode.cn/problems/non-overlapping-intervals/solutions/541919/435-wu-zhong-die-qu-jian-tan-xin-jing-di-qze0/?orderBy=most_votes
 */
public class EraseOverlapIntervals {
    public static void main(String[] args) {
        //  int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        int result = eraseOverlapIntervals.eraseOverlapIntervals(intervals);
        System.err.println("result : " + result);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        System.err.println(Arrays.deepToString(intervals));

        //  ok count ;
        int count = 1;

        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                count++;
                end = intervals[i][1];
            }

        }

        return intervals.length - count;


    }
}
