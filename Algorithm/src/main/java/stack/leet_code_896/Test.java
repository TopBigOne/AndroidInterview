package stack.leet_code_896;

/**
 * @author : dev
 * @version :
 * @Date :  2/28/21 10:32 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        IsMonotonic isMonotonic = new IsMonotonic();
        int[] raws = {1, 2, 3, 3};
        boolean monotonic = isMonotonic.isMonotonic(raws);
        System.out.println("monotonic : " + monotonic);
    }




}
