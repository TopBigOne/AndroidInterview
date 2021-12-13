package single_invoke_stack.leet_code_1475;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/4 23:01
 * @Url :
 * @Level :  easy
 * @Desc : https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop/submissions/
 * @Counter :
 * @Answer :
 * <p>
 * https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop/solution/dan-diao-zhan-zui-quan-mian-xiang-jie-bao-ni-dong-/
 */
public class FinalPrices {
    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};

        FinalPrices finalPrices = new FinalPrices();
        finalPrices.finalPrices(prices);
    }

    public int[] finalPrices(int[] prices) {
        int length = prices.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                prices[index] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }

    public int[] finalPrices2(int[] prices) {
        int length = prices.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                prices[index] -= prices[i];
            }
            stack.push(i);
        }

        return prices;
    }

    public int[] finalPrices3(int[] prices) {
        int length = prices.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            int currValue = prices[i];
            while (!stack.isEmpty() && prices[stack.peek()] >= currValue) {
                Integer index = stack.pop();
                prices[index] -= currValue;
            }
            stack.push(i);
        }

        return prices;


    }
}
