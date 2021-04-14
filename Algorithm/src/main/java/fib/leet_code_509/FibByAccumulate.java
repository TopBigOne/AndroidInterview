package fib.leet_code_509;

/**
 * @author : dev
 * @version :
 * @Date :  2/8/21 2:41 PM
 * @Desc : 计算裴波那楔数列，通过累加的方式
 */
public class FibByAccumulate {
    public int fib(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = res;
            res += pre;
            pre = temp;
        }
        return res;
    }

    public int fib2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int pre = 1;
        int res = 1;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = res;
            res += pre;
            pre = temp;
        }
        return res;
    }

    public int fib3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = res;
            res += pre;
            pre = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        FibByAccumulate accumulate = new FibByAccumulate();
        int result = accumulate.fib(45);
        System.out.println("result:" + result);
    }


}
