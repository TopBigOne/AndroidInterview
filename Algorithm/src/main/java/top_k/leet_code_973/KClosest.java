package top_k.leet_code_973;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/9 16:13
 * @Desc : 最接近原点的 K 个点
 * <p>
 * https://leetcode.cn/problems/k-closest-points-to-origin/
 */
public class KClosest {
    public static void main(String[] args) {
        KClosest kClosest = new KClosest();
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        int[][] result = kClosest.kClosest(points, k);
        System.out.println("result : " + Arrays.deepToString(result));
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Map<Integer, int[]>> minHeap = new PriorityQueue<>((o1, o2) -> {
            int one = o1.keySet().stream().findFirst().get();
            int two = o2.keySet().stream().findFirst().get();
            return one - two;
        });
        for (int[] point : points) {
            int one = point[0];
            int two = point[1];
            int val = (int) (Math.pow(one, 2) + Math.pow(two, 2));
            Map<Integer, int[]> map = new HashMap<>();
            map.put(val, new int[]{one, two});

            minHeap.add(map);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Map<Integer, int[]> map = minHeap.poll();
            Set<Map.Entry<Integer, int[]>> entries = map.entrySet();
            for (Map.Entry<Integer, int[]> entry : entries) {
                result[i] = entry.getValue();
            }
        }
        return result;

    }
}
