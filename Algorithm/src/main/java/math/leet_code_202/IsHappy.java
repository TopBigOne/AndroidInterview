package math.leet_code_202;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/27 18:16
 * @Desc :
 * https://leetcode.cn/problems/happy-number/
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * <p>
 * 题解：https://leetcode.cn/problems/happy-number/solution/shi-yong-kuai-man-zhi-zhen-si-xiang-zhao-chu-xun-h/
 */
public class IsHappy {

    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        boolean happy = isHappy.isHappy(19);
        System.out.println("happy : "+ happy);
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            System.out.println(" slow ：" + slow);
            System.out.println(" fast ：" + fast);
            System.out.println(" ------------------|");
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);


            fast = bitSquareSum(fast);
        } while (slow != fast);
        return slow == 1;

    }

    private int bitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            // 取余
            int bit = n % 10;
            sum += Math.pow(bit, 2);
            System.err.println("bit : " + bit);
            System.err.println("sum : " + sum);
            System.err.println("-----------------|");
            n /= 10;
        }


        return sum;
    }
}
