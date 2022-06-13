package queue.offer_59_2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/12 23:27
 * @Desc :
 */
public class MaxQueue {

    Deque<Integer> queue = new ArrayDeque<>();
    Deque<Integer> help = new ArrayDeque<>();

    public MaxQueue() {

    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        if (help.isEmpty()) {
            return -1;
        }

        return help.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!help.isEmpty() && value > help.peekLast()) {
            help.pollLast();
        }
        help.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }

        int val = queue.pollFirst();
        if (!help.isEmpty() && help.peekFirst() == val) {
            help.pollFirst();
        }
        return val;

    }


}
