package stack.array_stack;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  3/4/21 5:05 PM
 * @Desc :
 */
public class ArrayStack2 {

    private String[] items;
    private int count;
    private int n;


    public ArrayStack2(int n) {
        items = new String[n];
        this.n = n;
        this.count = 1;
    }


    public String peek() {
        String t = null;
        if (count > 0) {
            t = items[count - 1];
        }
        return t;
    }

    public boolean push(String x) {
        expandCapacity(count+1);
        items[count] = x;
        count++;
        return true;

    }

    public String pop() {
        if (count==0) {
            return null;
        }
        String temp = items[count-1];
        count--;
        return  temp;
    }

    private void expandCapacity(int size){
        if (size>n) {
            n = size+(size>>1)+1;
        }

        items = Arrays.copyOf(items,n);
    }


}
