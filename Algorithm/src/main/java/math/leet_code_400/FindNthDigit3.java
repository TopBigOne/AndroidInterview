package math.leet_code_400;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/15 16:18
 * @Desc : 400. 第 N 位数字
 * <p>
 * 视频题解：https://leetcode.cn/problems/nth-digit/solution/xiao-song-man-bu-xun-huan-jian-qu-ji-shu-kp0d/
 */
public class FindNthDigit3 {
    public static void main(String[] args) {
        FindNthDigit3 findNthDigit = new FindNthDigit3();
        int result = findNthDigit.findNthDigit(300);
        System.err.println("result : " + result);
    }

    public int findNthDigit(int n) {
        System.err.println("n status one : " + n);
        int base = 1;
        int weight = 9;
        // 300
        long span;
        while ((span = (long) base * weight) < n) {
            System.err.println("span : " + span);
            n -= span;
            System.err.println("n change : " + n);
            base++;
            weight *= 10;
            System.err.println("----------------");
        }
        // n 111  base = 3, weight = 900;

        n--;
        System.err.println("n status two : " + n);
        int res = (int) Math.pow(10, base - 1) + n / base;
        System.err.println("res : " + res);
        int index = n % base;

        System.err.println("index : " + index);
        return String.valueOf(res).charAt(index) - '0';


    }
}
