package interval.leet_code_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  4/26/21 8:15 PM
 * @Desc :  56:合并区间：题解：https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
 * 题解：  https://www.youtube.com/watch?v=Og40pFaGCxs
 */
public class Merge {



    /**
     * @param intervals 间隔
     */
    public int[][] merge(int[][] intervals) {
        // 从小到大进行排序
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
                continue;
            }
            // 反之 将当前区间合并至结果数组的最后区间
            res[idx][1] = Math.max(res[idx][1], interval[1]);

        }
        return Arrays.copyOf(res, idx + 1);

    }

    public int[][] merge2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        //放置第一个数组
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
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
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 最小的放在前面
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastArray = result.get(result.size() - 1);
            if (lastArray[1] >= intervals[i][0]) {
                lastArray[1] = Math.max(lastArray[1], intervals[i][1]);
                continue;
            }
            result.add(intervals[i]);
        }
        return result.toArray(new int[result.size()][2]);

    }


    public int[][] merge4(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastArray = result.get(result.size() - 1);
            if (lastArray[1] >= intervals[i][0]) {
                lastArray[1] = Math.max(lastArray[1], intervals[i][1]);
                continue;
            }
            result.add(intervals[i]);

        }

        return result.toArray(new int[result.size()][2]);

    }


    public int[][] merge5(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastArray = result.get(result.size() - 1);
            if (lastArray[1] >= intervals[i][0]) {
                lastArray[1] = Math.max(lastArray[1], intervals[i][1]);
                continue;
            }
            result.add(intervals[i]);
        }
        return result.toArray(new int[result.size()][2]);
    }


    public int[][] merge6(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastArray = result.get(result.size() - 1);
            if (lastArray[1] >= intervals[i][0]) {
                lastArray[1] = Math.max(lastArray[1], intervals[i][1]);
                continue;
            }

            result.add(intervals[i]);
        }

        return result.toArray(new int[result.size()][2]);
    }


}
