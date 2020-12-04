package dynamic_programming;

/**
 * @author : dev
 * @version :
 * @Date :  12/3/20 9:08 PM
 * @Desc :  动态规划-https://mp.weixin.qq.com/s/-DT0b_W1Vqs0tVANhCB4-w
 */
public class Demo_1 {

    /**
     * 递归方式求解
     *
     * @param n
     * @return
     */
    int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


}



