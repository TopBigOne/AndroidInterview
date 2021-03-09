package stack.array_stack;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  3/4/21 6:36 PM
 * @Desc :  用数组实现一个栈
 */
public class ArrayStack6 {

    private String[] items;
    private int n;
    private int count;

    private ArrayStack6(int n) {
        items = new String[n];
        this.n = n;
        count = 0;
    }


    public String peek() {
        String temp = null;
        if (count > 0) {
            temp = items[count - 1];
        }
        return temp;
    }

    public boolean push(String x) {
        expandCapacity(count + 1);
        items[count] = x;
        count++;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String temp = items[count - 1];
        count--;
        return temp;
    }


    private void expandCapacity(int size) {
        if (size > n) {
            n = size + (size >> 1) + 1;
            items = Arrays.copyOf(items, n);
        }
    }


}
