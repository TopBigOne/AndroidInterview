package array.leet_code_406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/13 23:31
 * @Url : https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/xian-pai-xu-zai-cha-dui-dong-hua-yan-shi-suan-fa-g/
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                return p2[0] - p1[0];
            } else {
                return p1[1] - p2[1];
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            if (list.size() > person[1]) {
                list.add(person[1], person);
                continue;
            }
            list.add(list.size(), person);
        }
        return list.toArray(new int[list.size()][]);

    }

    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            int size = list.size();
            if (size > person[1]) {
                list.add(person[1], person);
                continue;
            }
            list.add(size, person);
        }
        return list.toArray(new int[list.size()][]);
    }

    public int[][] reconstructQueue3(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            int size = list.size();
            if (size > person[1]) {
                list.add(person[1], person);
                continue;
            }
            list.add(size, person);
        }
        return list.toArray(new int[list.size()][]);

    }

    public int[][] reconstructQueue4(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            int size = list.size();
            if (size > person[1]) {
                list.add(person[1], person);
                continue;
            }
            list.add(size, person);

        }

        return list.toArray(new int[list.size()][]);

    }

    public int[][] reconstructQueue5(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            int size = list.size();
            if (size > person[1]) {
                list.add(person[1], person);
                continue;
            }
            list.add(size, person);
        }

        return list.toArray(new int[list.size()][]);

    }

    public int[][] reconstructQueue6(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            int size = list.size();
            if (size > person[1]) {
                list.add(person[1], person);
                continue;
            }
            list.add(size, person);
        }

        return list.toArray(new int[list.size()][]);


    }


}
