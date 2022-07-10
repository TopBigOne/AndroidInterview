package interval.leet_code_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/8 18:53
 * @Url : https://leetcode-cn.com/problems/merge-intervals/
 * @Level :    medium
 * @Desc : 合并区间
 * @Counter :22
 * @Answer : https://www.youtube.com/watch?v=Og40pFaGCxs
 */
public class Merge2 {

    public static void main(String[] args) {

        int[][] intervals = {{1, 4}, {4, 5}};

        Merge2 merge = new Merge2();
        int[][] result = merge.merge(intervals);
        System.err.println("result : " + Arrays.deepToString(result));


    }

    public int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        int len = intervals.length;
        for (int i = 1; i < len; i++) {

            int[] currArray = intervals[i];
            // 最后一个：区间数组
            int[] lastArray = result.get(result.size() - 1);

            if (lastArray[1] >= currArray[0]) {
                lastArray[1] = Math.max(lastArray[1], currArray[1]);
            } else {
                result.add(currArray);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        int len = intervals.length;
        for (int i = 1; i < len; i++) {
            int[] lastArray = result.get(result.size() - 1);
            if (lastArray[1] >= intervals[i][0]) {
                lastArray[1] = Math.max(lastArray[1], intervals[i][1]);
                continue;
            }
            result.add(intervals[i]);
        }

        return result.toArray(new int[result.size()][2]);

    }

    public int[][] merge3(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<int[]> result = new ArrayList<>();

        for (int[] currInterval : intervals) {
            if (result.isEmpty()) {
                result.add(currInterval);
                continue;
            }

            int[] lastInterval = result.get(result.size() - 1);
            if (lastInterval[1] >= currInterval[0]) {
                lastInterval[1] = Math.max(lastInterval[1], currInterval[1]);
            } else {
                result.add(currInterval);
            }
        }

        return result.toArray(new int[result.size()][2]);

    }


}
