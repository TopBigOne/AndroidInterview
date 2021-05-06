package math.leet_code_07;

/**
 * @author : dev
 * @version :
 * @Date :  3/27/21 10:45 PM
 * @Desc : 整数反转 (https://leetcode-cn.com/problems/reverse-integer/submissions/)
 * <p>
 * （https://leetcode-cn.com/problems/reverse-integer/solution/hua-jie-suan-fa-7-zheng-shu-fan-zhuan-by-guanpengc/）
 * <p>
 * https://leetcode-cn.com/problems/reverse-integer/solution/chi-xiao-dou-li-jie-gong-shi-tui-dao-jav-aauv/
 */
public class Reverse {
    // 7是2^31 - 1的个位数
    // 8是-2^31的个位数

    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            System.out.println();
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;

    }

    public int reverse2(int x) {
        int ans = 0;
        while (x != 10) {
            // 下一位
            int pop = x % 10;
            int maxResult = Integer.MAX_VALUE / 10;
            if (ans > maxResult || ans == maxResult && pop > 7) {
                return 0;
            }
            int minResult = Integer.MIN_VALUE / 10;
            if (ans < minResult || ans == minResult && pop < -8) {
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

    public int reverse3(int x) {
        int ans = 0;
        while (x != 0) {
            // 得到当前整数的最后一位
            int pop = x % 10;
            int maxResult = Integer.MAX_VALUE / 10;
            if (ans > maxResult || ans == maxResult && pop > 7) {
                return 0;
            }
            int minResult = Integer.MIN_VALUE / 10;
            if (ans < minResult || ans == minResult && pop < -8) {
                return 0;
            }
            ans = 10 * ans + pop;
            x /= 10;

        }

        return ans;
    }

    public int reverse4(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            int maxResult = Integer.MAX_VALUE / 10;
            if (ans > maxResult || ans == maxResult && pop > 7) {
                return 0;
            }
            int minResult = Integer.MIN_VALUE / 10;
            if (ans < minResult || ans == minResult && pop < -8) {
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }


    public int reverse5(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            int maxResult = Integer.MAX_VALUE / 10;
            if (ans > maxResult || ans == maxResult && pop > 7) {
                return 0;
            }
            int minResult = Integer.MIN_VALUE / 10;
            if (ans < minResult || ans == minResult && pop < -8) {
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

    public int reverse6(int x) {
        int result = 0;
        int digit = 0;
        while (x != 0) {

            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            // 获取每次循环的个位数
            digit = x % 10;
            // 数字 x 每次位数就减1，如 123/10 = 12
            x /= 10;
            result = result * 10 + digit;
        }

        return 0;
    }

    public int reverse7(int x) {
        int result = 0;
        int digit = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }

            digit = x % 10;
            x /= 10;
            result = result * 10 + digit;
        }
        return result;
    }


}
