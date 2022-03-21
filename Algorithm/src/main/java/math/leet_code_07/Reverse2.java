package math.leet_code_07;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/3/17 13:57
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Reverse2 {

    public static void main(String[] args) {
        Reverse2 reverse2 = new Reverse2();
        int result = reverse2.reverse(123);
        System.out.println("result :" + result);
    }

    public int reverse(int x) {
        int result = 0;
        int digit = 0;
        System.out.println("--------------------------|");
        while (x != 0) {
            digit = x % 10;
            x /= 10;
            result = result * 10 + digit;
            System.out.println("digit  : " + digit);
            System.out.println("x      : " + x);
            System.out.println("result : " + result);
            System.out.println("--------------------------|");


        }
        return result;
    }
}
