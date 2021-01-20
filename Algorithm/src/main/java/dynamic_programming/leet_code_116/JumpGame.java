package dynamic_programming.leet_code_116;


/**
 * @author : dev
 * @version :
 * @Date :  1/18/21 1:30 AM
 * @Desc :
 */
public class JumpGame {
    public boolean canJump(int[] a) {
        int n = a.length;
        boolean[] f = new boolean[n];
        // initialization
        f[0] = true;
        for (int j = 1; j < n; j++) {
            f[j] = false;
            // previous stone i;
            // last junp is from i to j;
            for (int i = 0; i < j; i++) {
                if (f[i] && i + a[i] >= j) {
                    f[j] = true;
                    break;
                }
            }
        }
        return f[n - 1];
    }

}
