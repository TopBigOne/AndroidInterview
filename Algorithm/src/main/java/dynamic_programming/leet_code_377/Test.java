package dynamic_programming.leet_code_377;

/**
 * @author : dev
 * @version :
 * @Date :  1/29/21 11:01 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        CombinationSum combinationSum = new CombinationSum();
        int combination = combinationSum.combination11(nums, target);
        System.out.println("result:"+combination);

    }
}
