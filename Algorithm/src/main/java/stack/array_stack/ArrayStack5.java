package stack.array_stack;


import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  3/4/21 6:17 PM
 * @Desc :
 */
public class ArrayStack5 {
    String[] items;
    int count;
    int n;

    public ArrayStack5(int n) {
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
