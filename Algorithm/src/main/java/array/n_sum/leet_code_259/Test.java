package array.n_sum.leet_code_259;

/**
 * @author : dev
 * @version :
 * @Date :  6/19/21 8:13 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        ThreeSumSmaller threeSumSmaller = new ThreeSumSmaller();
        int[] nums = {-2, 0, 1, 3};
        int result = threeSumSmaller.threeSumSmaller(nums, 2);
        System.out.println("result : " + result);
    }
}
