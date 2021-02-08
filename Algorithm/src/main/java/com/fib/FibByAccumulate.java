package com.fib;

/**
 * @author : dev
 * @version :
 * @Date :  2/8/21 2:41 PM
 * @Desc : 计算裴波那楔数列，通过累加的方式
 */
public class FibByAccumulate {
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 2) {
            return n;
        } else if (n == 1) {
            return n;
        }
        int temp;
        int res = 2;
        int pre = 1;
        for (int i = 3; i < n; i++) {
            temp = res;
            res += pre;
            pre = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        FibByAccumulate accumulate = new FibByAccumulate();
        int result = accumulate.fib(8);
        System.out.println("result:"+result);
    }

}
