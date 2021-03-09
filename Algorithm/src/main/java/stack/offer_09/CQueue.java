package stack.offer_09;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  3/4/21 11:07 PM
 * @Desc :
 */
public class CQueue {


    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(5);
        cQueue.appendTail(2);

        cQueue.deleteHead();
        cQueue.deleteHead();

    }
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> reverse = new Stack<>();

    public CQueue() {

    }


    // 在队尾插入
    public void appendTail(int value) {
        while (!reverse.isEmpty()) {
            normal.push(reverse.pop());
        }
        reverse.push(value);

        while (!normal.isEmpty()) {
            reverse.push(normal.pop());
        }

    }

    // 删除队列头
    public int deleteHead() {
        if (reverse.isEmpty()) {
            return -1;
        }
        return reverse.pop();
    }

}
