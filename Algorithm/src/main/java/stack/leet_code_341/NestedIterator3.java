package stack.leet_code_341;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/3 22:47
 * @Desc :
 */
public class NestedIterator3 implements Iterator<Integer> {
    Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIterator3(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.addLast(list.get(i));

        }
    }


    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }
        NestedInteger item = stack.peekLast();
        if (item.isInteger()) {
            return true;
        }

        item = stack.pollLast();
        if (item == null) {
            return false;
        }
        List<NestedInteger> list = item.getList();
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.addLast(list.get(i));
        }

        return hasNext();
    }

    @Override
    public Integer next() {
        return hasNext() ? stack.pollLast().getInteger() : -1;
    }
}
