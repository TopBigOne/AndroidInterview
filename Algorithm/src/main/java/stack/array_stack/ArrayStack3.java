package stack.array_stack;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  3/4/21 5:30 PM
 * @Desc :
 */
public class ArrayStack3 {
    String[] items;
    int count;
    int n;

    public ArrayStack3(int n) {
        items = new String[n];
        this.n = n;
        count = 0;
    }

    public String peek() {
        String t = null;
        if (count > 0) {
            t = items[count - 1];
        }
        return t;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String item = items[count - 1];
        count--;
        return item;
    }

    public boolean push(String x) {
        expandCapacity(count + 1);
        items[count++] = x;
        return true;
    }

    private void expandCapacity(int size) {
        if (size > n) {
            n = size + (size >> 1) + 1;
            items = Arrays.copyOf(items, n);
        }
    }


}
