package single_invoke_queue.leet_code_239;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/13 14:47
 * @Desc :
 */
public class MaxSlidingWindow8 extends Base {
    public static void main(String[] args) {
        MaxSlidingWindow8 maxSlidingWindow8 = new MaxSlidingWindow8();
        maxSlidingWindow8.maxSlidingWindow(nums, k);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        Window window = new Window();
        for (int i = 0; i < nums.length; i++) {

            int currValue = nums[i];
            if (i < k - 1) {
                window.push(currValue);
                continue;
            }
            window.push(currValue);
            int maxValue = window.getMax();
            result.add(maxValue);

            int popIndex  = i - k + 1;
            System.out.println("popIndex :"+popIndex);
            window.pop(nums[popIndex]);

          //  System.out.println("currValue :" + currValue);
        }


        return result.stream().mapToInt(a -> a).toArray();

    }

    public static class Window {

        Deque<Integer> queue = new ArrayDeque<>();


        public void push(int num) {
            while (queue.size() > 0 && queue.peekLast() < num) {
                queue.pollLast();
            }
            queue.addLast(num);
        }

        public int getMax() {
            return queue.getFirst();
        }


        public int pop(int num) {
            if (queue.getFirst() == num) {
                return queue.pollFirst();
            }
            return -1;
        }


    }

}
