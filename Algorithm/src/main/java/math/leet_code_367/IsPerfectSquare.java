package math.leet_code_367;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/10/26 23:21
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer : 原理：原理:(n+1)^2-n^2=2n+1
 * <p>
 * 1 4=1+3 9=1+3+5 16=1+3+5+7以此类推
 * <p>
 * 题解：https://leetcode.cn/problems/valid-perfect-square/solutions/93200/zhi-xing-yong-shi-0-ms-zai-suo-you-c-ti-jiao-zh-44/?orderBy=most_votes
 */
public class IsPerfectSquare {

    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        boolean result = isPerfectSquare.isPerfectSquare(9);
        System.err.println("result : " + result);
    }

    public boolean isPerfectSquare(int num) {
        int num1 = 1;
        while (num > 0) {
            num -= num1;
            num1 += 2;
        }
        return num == 0;
    }

    public boolean isPerfectSquare2(int num) {
        int num1 = 1;
        while (num > 0) {
            num -= num1;
            num1 += 2;
        }
        return num == 0;


    }


}
