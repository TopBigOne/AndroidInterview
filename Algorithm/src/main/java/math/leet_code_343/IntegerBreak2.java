package math.leet_code_343;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/11 18:44
 * @Desc :
 */
public class IntegerBreak2 {
    public int cuttingRope(int n) {
        if (n == 1 || n == 2)
            return 1;
        if (n == 3){
            return 2;
        }

        int sum = 1;

        while (n > 4) {
            sum *= 3;
            n -= 3;
        }

        return sum * n;
    }
}
