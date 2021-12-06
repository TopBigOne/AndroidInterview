package single_invoke_stack.leet_code_901;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/6 22:12
 * @Url :https://leetcode-cn.com/problems/online-stock-span/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/online-stock-span/solution/gu-piao-jie-ge-kua-du-dan-diao-zhan-by-b-umdh/
 */
public class StockSpanner {
    private final Deque<Integer> stack;
    private final List<Integer> numList;

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int resultOne = stockSpanner.next(100);
        System.out.println("resultOne   : " + resultOne);

        int resultTwo = stockSpanner.next(80);
        System.out.println("resultTwo   : " + resultTwo);

        int resultThree = stockSpanner.next(60);
        System.out.println("resultThree : " + resultThree);

        int resultFour = stockSpanner.next(70);
        System.out.println("resultFour  : " + resultFour);


    }

    public StockSpanner() {
        stack = new ArrayDeque<>();
        numList = new ArrayList<>();
    }

    public int next(int price) {
        int res = 0;
        numList.add(price);
        while (!stack.isEmpty() && numList.get(stack.peek()) <= price) {
            stack.pop();
        }

        // 栈是空的
        int size = numList.size();
        if (stack.isEmpty()) {
            res = size;
        } else {
            res = size - 1 - stack.peek();
        }
        stack.push(size - 1);
        return res;
    }

    public int next2(int price) {
        int res = 0;
        numList.add(price);
        while (!stack.isEmpty() && numList.get(stack.peek()) <= price) {
            stack.pop();
        }
        int size = numList.size();
        // 栈是空的
        if (stack.isEmpty()) {
            res = size;
        } else {
            res = size - 1 - stack.peek();
        }
        stack.push(size - 1);
        return res;
    }

    public int next3(int price) {
        int res = 0;
        numList.add(price);

        while (!stack.isEmpty() && numList.get(stack.peek()) <= price) {
            stack.pop();
        }


        int size = numList.size();
        if (stack.isEmpty()) {
            res = size;
        } else {
            res = size - 1 - stack.peek();
        }

        stack.push(size - 1);
        return res;
    }


}
