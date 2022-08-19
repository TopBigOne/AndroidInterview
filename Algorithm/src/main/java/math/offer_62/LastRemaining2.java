package math.offer_62;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/17 23:42
 * @Desc :
 */
public class LastRemaining2 {
    public int lastRemaining(int n, int m) {
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i;

        }
        return pos;


    }
}
