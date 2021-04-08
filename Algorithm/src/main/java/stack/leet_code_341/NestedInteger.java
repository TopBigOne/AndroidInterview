package stack.leet_code_341;

import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/3 16:47
 * @Desc :  This is the interface that allows for creating nested lists.
 *          You should not implement it, or speculate about its implementation
 */

public interface NestedInteger {
    /**
     *  是否只包含一个整数
     * @return true if this NestedInteger holds a single integer, rather than a nested list.
     */
    boolean isInteger();


    /**
     *
     * @return the single integer that this NestedInteger holds, if it holds a single integer
     * Return null if this NestedInteger holds a nested list
     */
    Integer getInteger();

    /**
     * 是一个集合
     * @return the nested list that this NestedInteger holds, if it holds a nested list
     * Return empty list if this NestedInteger holds a single integer
     */
    List<NestedInteger> getList();
}
