package math.leet_code_400;

/**
 * @author : dev
 * @version :
 * @Date :  11/30/21 9:08 PM
 * @Desc :
 * <p>
 * https://leetcode-cn.com/problems/nth-digit/solution/wei-ruan-zhao-pin-ing-400-di-n-wei-shu-z-hb7i/
 */
public class FindNthDigit {
    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        int nthDigit = findNthDigit.findNthDigit(12);
        System.err.println("the  digit  is : " + nthDigit);
    }

    public int findNthDigit(int n) {
        long N = n;
        // 位数
        int digits = 1;
        // digits 位数一共产生了多少位数字
        long border = 9;
        while (N > 0) {
            if (N <= border * digits) {
                break;
            }
            // 当前N 为扣除所有 digits 位数字（比如两位数）产生的数字后，还剩下多少数字
            N -= border * digits;
            digits++;
            border *= 10;
        }
        // 循环结束以后，剩余的 N 都是由 digits 位数贡献的；
        // 每个 digits 位数，均产生 ditgits 个'单个'数字，因而可以通过求除，求余数得到 n 对应的第几个 digits 位数
        int offset = (int) (N - 1) / digits;
        int begin = (int) border / 9;
        int mod = (int) (N - 1) % digits;
        String target = String.valueOf(offset + begin);
        return target.charAt(mod) - '0';

    }

    public int findNthDigit2(int n) {
        int N = n;
        int digits = 1;
        // digits 位数产生的多少位数
        long border = 9;
        while (N > 0) {
            if (N <= border * digits) {
                break;
            }
            N -= border * digits;
            digits++;
            border *= 10;
        }

        int offset = (int) (N - 1) / digits;
        int begin = (int) border / 9;

        int mod = (N - 1) % digits;
        String target = String.valueOf(offset + begin);
        return target.charAt(mod) - '0';
    }

    public int findNthDigit3(int n) {
        int N = n;
        int digits = 1;
        long border = 9;
        while (N > 0) {
            if (N <= border * digits) {
                break;

            }
            N -= border * digits;
            digits++;
            border *= 10;
        }

        int offset = (N - 1) / digits;
        int begin = (int) (border / 9);
        int mod = (N - 1) % digits;
        String target = String.valueOf(offset + begin);
        return target.charAt(mod) - '0';
    }

    public int findNthDigit4(int n) {
        int N = n;
        int digits = 1;
        long border = 9;
        while (N > 0) {
            if (N <= digits * border) {
                break;
            }
            N -= border * digits;
            digits++;
            border *= 10;
        }

        int offset = (N - 1) / digits;
        int begin = (int) (border / 9);
        int mod = (N - 1) % digits;
        String target = String.valueOf(offset + begin);
        return target.charAt(mod) - '0';
    }

    public int findNthDigit5(int n) {
        int N = n;
        int digits = 1;
        long border = 9;
        while (N > 0) {
            if (N <= border * digits) {
                break;
            }
            N -= border * digits;
            digits++;
            border *= 10;
        }
        int offset = (N - 1) / digits;
        int begin = (int) (border / 9);
        int mod = (N - 1) % digits;

        String target = String.valueOf(offset + begin);
        return target.charAt(mod) - '0';

    }

    public int findNthDigit6(int n) {
        int N = n;
        long border = 9;
        int digits = 1;
        while (N > 0) {
            if (N <= digits * border) {
                break;
            }
            N -= digits * border;
            border *= 10;
            digits++;
        }

        int offset = (N - 1) / digits;
        int begin = (int) (border / 9);
        int mod = (N - 1) % digits;
        String target = String.valueOf(offset + begin);
        return target.charAt(mod) - '0';

    }

    public int findNthDigit7(int n) {
        int N = n;
        long border = 9;
        int digits = 1;
        while (N > 0) {
            if (N <= border * digits) {
                break;
            }
            N -= border * digits;
            digits++;
            border *= 10;
        }

        int offerset = (N - 1) / digits;
        int begin = (int) (border / 9);

        int mod = (N - 1) % digits;
        String target = String.valueOf(offerset + begin);
        return target.charAt(mod) - '0';

    }

    public int findNthDigit8(int n) {
        int N = n;
        long border = 9;
        int digits = 1;
        while (N > 0) {
            if (N <= border * digits) {
                break;
            }
            N -= border * digits;
            digits++;
            border *= 10;
        }

        int offset = (N - 1) / digits;
        int begin = (int) (border / 9);
        int mod = (N - 1) % digits;
        String target = String.valueOf(begin + offset);
        return target.charAt(mod) - '0';


    }


}
