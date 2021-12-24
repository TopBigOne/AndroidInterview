package tan_xin.leet_code_1705;

import java.beans.EventHandler;
import java.beans.beancontext.BeanContext;
import java.util.Comparator;
import java.util.PriorityQueue;

import javax.lang.model.util.AbstractAnnotationValueVisitor6;
import javax.management.DynamicMBean;

import back_tracking.offer_38.Permutation_1;

/**
 * @author : dev
 * @version :
 * @Date :  12/24/21 9:14 PM
 * @Desc :
 */
public class EatenApples2 {
    /**
     * 很简单,优先吃掉最先腐烂的那堆苹果即可
     * 使用优先队列(小根堆)去维护腐烂时间和苹果数量。
     * 当腐烂时或苹果数量为0时，出队。
     *
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        //小根堆
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        int ans = 0, day = 0;
        for (int i = 0; i < n; i++) {
            day++;
            if (apples[i] != 0) {
                heap.offer(new int[]{apples[i], i + days[i] + 1});
            }
            while (!heap.isEmpty()) {
                int[] tmp = heap.peek();
                //当堆顶的苹果已经到腐烂，或者吃完了，则出队
                if (tmp[1] == day || tmp[0] == 0) {
                    heap.poll();
                } else {
                    ans++;
                    //吃一颗苹果,堆顶苹果-1
                    heap.peek()[0]--;
                    break;
                }
            }
        }
        //可能会有剩余的苹果
        day++;
        while (!heap.isEmpty()) {
            int[] tmp = heap.peek();
            if (tmp[1] == day || tmp[0] == 0) {
                heap.poll();
            } else {
                day++;
                ans++;
                heap.peek()[0]--;
            }
        }
        return ans;


    }

    public int eatenApples2(int[] apples, int[] days) {
        int len = apples.length;
        // 小根堆
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int ans = 0;
        int day = 0;
        for (int i = 0; i < len; i++) {
            day++;
            if (apples[i] != 0) {
                int produceAppleCount = apples[i];
                int badAppleCount = i + days[i] + 1;
                int[] value = new int[]{produceAppleCount, badAppleCount};
                heap.offer(value);
            }

            while (!heap.isEmpty()) {
                int[] temp = heap.peek();
                // 当堆顶的苹果已经大奥腐烂，或者吃完了，则出队
                if (temp[1] == day || temp[0] == 0) {
                    heap.poll();

                } else {
                    ans++;
                    // 吃了一个苹果
                    heap.peek()[0]--;
                    break;
                }
            }
        }


        // 可能会有剩余的苹果
        day++;
        while (!heap.isEmpty()) {
            int[] temp = heap.peek();
            if (temp[1] == day || temp[0] == 0) {
                heap.poll();
            } else {
                day++;
                ans++;
                heap.peek()[0]--;
            }
        }
        return ans;

    }

    public int eatenApples3(int[] apples, int[] days) {
        int len = apples.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int ans = 0;
        int day = 0;
        for (int i = 0; i < len; i++) {
            day++;
            if (apples[i] != 0) {
                heap.offer(new int[]{apples[i], i + days[i] + 1});
            }
            while (!heap.isEmpty()) {
                int[] temp = heap.peek();

                if (temp[1] == day || temp[0] == 0) {
                    heap.poll();

                } else {
                    ans++;
                    heap.peek()[0]--;
                    break;
                }

            }

        }
        day++;
        while (!heap.isEmpty()) {
            int[] temp = heap.peek();
            if (temp[1] == day || temp[0] == 0) {
                heap.poll();
            } else {
                day++;
                ans++;
                heap.peek()[0]--;
            }
        }
        return ans;
    }


}
