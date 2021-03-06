package math.offer_49;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/15 18:19
 * @Desc : 剑指 Offer 49. 丑数  https://leetcode.cn/problems/chou-shu-lcof/
 *
 * <b>首先，任意一个丑数都等于它之前的一个丑数 乘2 或3 或5。<b/>
 * 因此，可以维护一个丑数列表，记录到当前丑数为止所有小于它的丑数。
 * 那么下一个丑数肯定是之前所有丑数都乘2或3或5中最小的一个。
 *
 * 关键就是加速“下一个丑数肯定是之前所有丑数都乘2或3或5中最小的一个”。
 * 分别用三个index指向三类（乘2，乘3，乘5）的数。怎么维护这三类数呢？每个数都应该是小于但是最接近当前丑数的那个数。
 *
 */
public class UglyNumber {
    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        int result = uglyNumber.nthUglyNumber(10);
        System.err.println("result :" + result);

    }

    /**
     * 说一下我对三指针的理解吧。 和动态规划没有关系。
     *
     * 我们知道，丑数的排列肯定是1,2,3,4,5,6,8,10.... 然后有一个特点是，任意一个丑数都是由小于它的某一个丑数*2，*3或者*5得到的，
     * 那么如何得到所有丑数呢？ 现在假设有3个数组，
     * 分别是：
     * A：{1*2，2*2，3*2，4*2，5*2，6*2，8*2，10*2......}
     *
     * B：{1*3，2*3，3*3，4*3，5*3，6*3，8*3，10*3......}
     *
     * C：{1*5，2*5，3*5，4*5，5*5，6*5，8*5，10*5......}
     *
     * 那么所有丑数的排列，必定就是上面ABC3个数组的合并结果然后去重得到的，
     *
     * 那么这不就转换成了三个有序数组的无重复元素合并的问题了吗？而这三个数组就刚好是{1,2,3,4,5,6,8,10....}乘以2,3,5得到的。
     *
     * 合并有序数组的一个比较好的方法，就是每个数组都对应一个指针，然后比较这些指针所指的数中哪个最小，就将这个数放到结果数组中，然后该指针向后挪一位。
     *
     * 回到本题，要求丑数ugly数组中的第n项，而目前只知道ugly[0]=1，所以此时三个有序链表分别就只有一个元素：
     *
     * A ： {1*2......}
     *
     * B ： {1*3......}
     *
     * C ： {1*5......}
     *
     * 假设三个数组的指针分别是i,j,k，此时均是指向第一个元素，然后比较A[i]，B[j]和C[k]，
     *
     * 得到的最小的数A[i]，就是ugly[1]，此时ugly就变成{1,2}了，对应的ABC数组就分别变成了：
     *
     * A ： {1*2，2*2......}
     *
     * B ： {1*3, 2*3......}
     *
     * C ：{1*5,2*5......}
     *
     * 此时根据合并有序数组的原理，A数组指针i就指向了下一个元素，即'2*2'，而j和k依然分别指向B[0]和C[0]，
     * 然后进行下一轮合并，就是A[1]和B[0]和C[0]比较，最小值作为ugly[2].....如此循环n次，就可以得到ugly[n]了。
     *
     * 此外，注意到ABC三个数组实际上就是ugly[]*2，ugly[]*3和ugly[]*5的结果，
     * 所以每次只需要比较A[i]=ugly[i]*2，B[j]=ugly[j]*3和C[k]=ugly[k]*5的大小即可。
     * 然后谁最小，就把对应的指针往后移动一个，为了去重，如果多个元素都是最小，那么这多个指针都要往后移动一个。
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int[] ugly = new int[n];
        // 基础丑数为1
        ugly[0] = 1;
        //初始分别指向三个有序链表第一个元素,这三个有序链表是想象出来的，分别就是ugly数组元素分别乘以2,3,5得到的
        int i = 0;
        int j = 0;
        int k = 0;
        for (int idx = 1; idx < n; idx++) {
            int minUglyNumber = Math.min(ugly[i] * 2, Math.min(ugly[j] * 3, ugly[k] * 5));
            System.err.println("temp change :" + minUglyNumber);
            // 三个链表可能有相同元素，所以只要是最小的，都要移动指针
            if (minUglyNumber == ugly[i] * 2) {
                System.err.println("i---> temp change * 2 = " + minUglyNumber);
                i++;
            }
            if (minUglyNumber == ugly[j] * 3) {
                System.err.println("j---> temp change * 3 = " + minUglyNumber);
                j++;
            }
            if (minUglyNumber == ugly[k] * 5) {
                System.err.println("k---> temp change * 5 = " + minUglyNumber);
                k++;
            }
            System.err.println("-------------------------------");
            ugly[idx] = minUglyNumber;
        }
        System.err.println(" all ugly :" + Arrays.toString(ugly));
        return ugly[n - 1];
    }

    public int nthUglyNumber2(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
