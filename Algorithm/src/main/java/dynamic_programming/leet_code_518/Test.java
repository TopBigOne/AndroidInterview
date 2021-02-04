package dynamic_programming.leet_code_518;

/**
 * @author : dev
 * @version :
 * @Date :  2/4/21 10:45 PM
 * @Desc :
 *
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 *
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 *
 *
 *
 */
public class Test {

    public static void main(String[] args) {
        int amount = 5;
        int  [] coins = {1, 2, 5};
        Solution solution = new Solution();
        int result = solution.change5(amount, coins);
        System.out.println("result : "+result);

    }
}
