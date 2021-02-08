package dp;

/**
 * @author : dev
 * @version :
 * @Date :  12/3/20 9:08 PM
 * @Desc :  动态规划-https://mp.weixin.qq.com/s/-DT0b_W1Vqs0tVANhCB4-w
 */
public class Demo_2 {
    public static void main(String[] args) {
        Demo_2 demo_2 = new Demo_2();
        long startTime = System.currentTimeMillis();
        long result = demo_2.fib(100);
        long endTime = System.currentTimeMillis();
        System.out.println("the result is : " + result + ",total time : " + (endTime - startTime));
    }

    /**
     * 保存子问题的解
     *
     * @param n
     * @return
     */
    long fib(int n) {
        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            System.out.println("f[" + i + "] = " + f[i]);
        }
        return f[n];
    }


}



