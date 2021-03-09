package stack.array_stack;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  3/4/21 4:39 PM
 * @Desc : 用数组实现一个栈。
 */
public class ArrayStack1 {
    private String[] items;
    private int count;
    // 数组大小
    private int n;

    private ArrayStack1(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    /**
     *
     * @return
     */
    public String peek() {
        String t = null;
        if (count > 0) {
            t = items[count - 1];
        }
        return t;
    }

    public boolean push(String item) {
        expandCapacity(count + 1);
        System.out.println("count:" + count + ", n:" + n);
        items[count] = item;
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

    public void expandCapacity(int size) {
        if (size > n) {
            n = size + (size >> 1) + 1;
            items = Arrays.copyOf(items,n);
        }
    }

}
