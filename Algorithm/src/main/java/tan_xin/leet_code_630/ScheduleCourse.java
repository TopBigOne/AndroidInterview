package tan_xin.leet_code_630;

import java.util.Arrays;
import java.util.PriorityQueue;

import javafx.scene.layout.Priority;

/**
 * @author : dev
 * @version :
 * @Date :  12/14/21 8:30 PM
 * @Desc :
 * <p>
 * https://leetcode-cn.com/problems/course-schedule-iii/
 * <p>
 * <p>
 * 题解：https://leetcode-cn.com/problems/course-schedule-iii/solution/gong-shui-san-xie-jing-dian-tan-xin-yun-ghii2/
 */
public class ScheduleCourse {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (c0, c1) -> c0[1] - c1[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);
        int sum = 0;
        for (int[] c : courses) {
            int d = c[0];
            int e = c[1];
            sum += d;
            queue.add(d);
            if (sum > e) {
                sum -= queue.poll();
            }
        }
        return queue.size();
    }

    public int scheduleCourse2(int[][] courses) {
        Arrays.sort(courses,(a,b)->b[1]-a[1]);


    }
}
