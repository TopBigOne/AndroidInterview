package stack.leet_code_341;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/3 16:01
 * @Desc : 扁平化嵌套列表迭代器（https://leetcode-cn.com/problems/flatten-nested-list-iterator/）
 * 是否能快速领悟一个新的数据结构的能力
 *
 * 视频：https://www.youtube.com/watch?v=R2dohSHOWXQ
 *
 *
 * {[[1,2,[3]]],[4,5]}
 * {,[4,5]}
 * [[1,2,[3]]]
 *
 *
 */
public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            NestedInteger item = list.get(i);
            stack.addLast(item);
        }
    }

    @Override
    public Integer next() {
        return hasNext() ? stack.pollLast().getInteger() : -1;
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }
        NestedInteger item = stack.peekLast();
        // 是 一个整数
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



}
