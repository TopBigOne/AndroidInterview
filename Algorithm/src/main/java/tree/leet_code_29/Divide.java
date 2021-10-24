package tree.leet_code_29;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/18 22:53
 * @Url :  https://leetcode-cn.com/problems/divide-two-integers/
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/divide-two-integers/solution/po-su-de-xiang-fa-mei-you-wei-yun-suan-mei-you-yi-/
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        // 当除数为1，直接返回除数
        if (divisor == 1) {
            return dividend;
        }

        // 当除数为-1，且除数为Integer.MIN_VALUE 时，将会溢出，返回Integer.MAX_VALUE
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        // 把被除数与除数调整为正数，为防止被除数Integer.MIN_VALUE转换为正数会溢出，使用long 类型，保存参数
        if (dividend < 0 && divisor < 0) {
            return divide(-(long) dividend, -(long) divisor);
        } else if (dividend < 0 || divisor < 0) {
            return -divide(Math.abs((long) dividend), Math.abs((long) divisor));
        } else {
            return divide(dividend, (long) divisor);
        }
    }

    public int divide(long dividend, long divisor) {
        // 如果被除数小于除数，结果明显为0
        if (dividend < divisor) {
            return 0;
        }
        // 记录用了count 个divisor 的 和
        long sum = divisor;
        // 使用了多少个divisor
        int count = 1;
        while (dividend >= sum) {
            // 每次翻倍
            sum <<= 1;
            count <<= 1;
        }

        sum>>=1;
        count>>>=1;
        // 此时dividend >= sum
        // 将count个divisor 从dividend 消耗掉，剩下的还需要多少个divisor 交由递归函数处理
        return count + divide(dividend - sum, divisor);

    }
}
