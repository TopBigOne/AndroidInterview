package stack.leet_code_896;

/**
 * @author : dev
 * @version :
 * @Date :   2/28/21 10:21 PM
 * @Desc :
 */
public class IsMonotonic {
    public boolean isMonotonic(int[] A) {
        boolean inc = true;
        boolean dec = true;
        int length = A.length;
        for (int i = 1; i < length; i++) {
            if (A[i] < A[i - 1]) inc = false;
            if (A[i] > A[i - 1]) dec = false;
            if (!inc && !dec) return false;
        }
        return true;
    }


    public boolean isMonotionic2(int[] a) {
        boolean inc = true;
        boolean dec = true;
        int length = a.length;
        for (int i = 1; i < length; i++) {
            if (a[i] < a[i - 1]) {
                inc = false;
            }
            if (a[i] > a[i - 1]) {
                dec = false;
            }
            if (!inc && !dec) {
                return false;
            }
        }
        return true;
    }

    public boolean isMonotionic3(int[] a) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) dec = false;
            if (a[i] < a[i - 1]) inc = false;
            if (!inc && !dec) return false;
        }
        return true;
    }


}
