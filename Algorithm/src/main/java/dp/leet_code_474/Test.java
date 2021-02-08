package dp.leet_code_474;

/**
 * @author : dev
 * @version :
 * @Date :  2/3/21 12:33 AM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        Solution solution = new Solution();
        int maxForm = solution.findMaxForm7(strs, m, n);
        System.out.println("maxForm:" + maxForm);
    }
}
