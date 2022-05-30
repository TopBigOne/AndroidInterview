package stack.offer_09;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/23 13:31
 * @Desc :
 */
public class CQueue2 {

    Stack<Integer> normal = new Stack<>();
    Stack<Integer> reverse = new Stack<>();

    public void appendTail(int value) {
        while (!reverse.isEmpty()) {
            normal.push(reverse.pop());
        }

        reverse.push(value);

        while (!normal.isEmpty()) {
            reverse.push(normal.pop());
        }
    }


    public int deleteHead() {
        if (reverse.isEmpty()) {
            return -1;
        }
        return reverse.pop();
    }
}
