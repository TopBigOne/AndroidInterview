package interval.leet_code_986;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/10 07:47
 * @Desc :
 * 题解：https://leetcode.cn/problems/interval-list-intersections/solution/jiu-pa-ni-bu-dong-shuang-zhi-zhen-by-hyj8/
 */
public class IntervalIntersection {
    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        IntervalIntersection intervalIntersection = new IntervalIntersection();
        int[][] result = intervalIntersection.intervalIntersection(firstList, secondList);
        System.err.println("result : " + Arrays.deepToString(result));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int len1 = firstList.length;
        int len2 = secondList.length;

        if (len1 == 0 || len2 == 0) {
            return new int[0][];
        }
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            int maxLeft = Math.max(firstList[i][0], secondList[j][0]);
            int minRight = Math.min(firstList[i][1], secondList[j][1]);
            if (maxLeft <= minRight) {
                res.add(new int[]{maxLeft, minRight});
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }

        }
        return res.toArray(new int[res.size()][2]);
    }
}
