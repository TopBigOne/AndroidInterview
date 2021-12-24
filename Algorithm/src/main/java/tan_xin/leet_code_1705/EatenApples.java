package tan_xin.leet_code_1705;

import java.util.PriorityQueue;

/**
 * @author : dev
 * @version :
 * @Date :  12/24/21 8:55 PM
 * @Desc :  吃苹果的最大数目 https://leetcode-cn.com/problems/maximum-number-of-eaten-apples/
 */
public class EatenApples {

    /**
     * 时间复杂度：令 nn 为数组长度，最多有 nn 组苹果入堆/出堆。复杂度为 O(n\log{n})O(nlogn)
     *
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int len = apples.length;
        int time = 0;
        int ans = 0;
        while (time < len || !q.isEmpty()) {
            if (time < len && apples[time] > 0) {
                int valueOne = time + days[time] - 1;
                int valueTwo = apples[time];
                int[] arr = new int[]{valueOne, valueTwo};
                q.add(arr);
            }

            while (!q.isEmpty() && q.peek()[0] < time) {
                q.poll();
            }

            if (!q.isEmpty()) {
                int[] cur = q.poll();
                if (--cur[1] > 0 && cur[0] > time) {
                    q.add(cur);
                }
                ans++;
            }
            time++;

        }

        return ans;


    }
}
