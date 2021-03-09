package stack.array_stack;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  3/4/21 5:59 PM
 * @Desc :
 */
public class ArrayStack4 {
    private String[] items;
    private int count;
    private int n;

    private ArrayStack4(int n) {
        items = new String[n];
        this.n = n;
        count = 0;
    }

    public boolean push(String s) {
        expandCapacity(count + 1);
        items[count] = s;
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

    public String peek() {
        String t = null;
        if (count > 0) {
            t = items[count - 1];
        }
        return t;
    }


    private void expandCapacity(int size) {
        if (size > n) {
            n = size + (size >> 1) + 1;
            items = Arrays.copyOf(items, n);
        }

    }

}
