package stack.leet_code_232;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/20 06:46
 * @Desc :
 */
public class MyQueueByStack2 {


    public MyQueueByStack2() {

    }


    Deque<Integer> normal = new ArrayDeque<>();
    Deque<Integer> reverse = new ArrayDeque<>();

    public void push(int x) {
        normal.push(x);
    }

    public int pop() {
        if (reverse.isEmpty()) {
            while (!normal.isEmpty()) {
                reverse.push(normal.pop());
            }
        }
        return reverse.pop();

    }

    public int peek() {
        if (reverse.isEmpty()) {
            while (!normal.isEmpty()) {
                reverse.push(normal.pop());
            }
        }
        return reverse.peek();

    }

    public boolean empty() {
        return reverse.isEmpty() && normal.isEmpty();

    }


}
