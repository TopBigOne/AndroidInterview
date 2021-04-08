package stack.leet_code_341;

import java.util.*;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/3 19:07
 * @Desc :
 */
public class NestedIterator2 implements Iterator<Integer> {

   private Deque<NestedInteger> stack = new ArrayDeque<>();
    public NestedIterator2(List<NestedInteger> list) {
        // 从尾部遍历，从尾部添加，这和头插法，也没啥区别吧
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

        // item 是一个列表啦；
        List<NestedInteger> list = item.getList();
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.addLast(list.get(i));
        }
        // 递归一下
        return hasNext();

    }

    @Override
    public Integer next() {
        return hasNext() ? stack.pollLast().getInteger() : -1;
    }
}
