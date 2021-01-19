package dynamic_programming;

import com.top.jar.chapter_001.t_08.MaxTree;

/**
 * @author : dev
 * @version :
 * @Date :  12/3/20 9:08 PM
 * @Desc :  动态规划-https://mp.weixin.qq.com/s/-DT0b_W1Vqs0tVANhCB4-w
 * 裴波那楔数列--备忘录版本
 *
 * 动态规划方法和备忘录方法 都是存储子问题的解的方法；
 * 动态规划：自底向上；
 * 备忘录 ：  自顶向下；
 * 两者在时间效率上较为接近；
 */
public class Demo_3 {
    public static void main(String[] args) {
        Demo_3 demo_3 = new Demo_3();
        long startTime = System.currentTimeMillis();
        long result = demo_3.fib(100);
        long endTime = System.currentTimeMillis();
        System.out.println("the result is : " + result + ",total time : " + (endTime - startTime));
    }


    // 备忘录大小
    final  int MAX = 100;
    // 特殊值
    final long NIL = -1;
    // 备忘录数组
    long[] lookup = new long[MAX];

    public void initializeTable() {
        for (int i = 0; i < MAX; i++) {
            lookup[i] = NIL;
        }
    }


    /**
     * 个人感觉，还是有递归的成分
     * @param n
     * @return
     */
    long fib(int n) {
        if (lookup[n] == NIL) {
            if (n <= 1) {
                lookup[n] = n;
            } else {
                lookup[n] = fib(n - 1) + fib(n - 2);
            }
            return lookup[n];
        }
        return 0;
    }


}



