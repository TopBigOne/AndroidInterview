package dp.packsack.leet_code_494;

/**
 * @author : dev
 * @version :
 * @Date :  2/3/21 5:44 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        FindTargetSumWay findTargetSumWay = new FindTargetSumWay();
        int[] nums = {1, 1, 1, 1, 1};
        int s = 3;
        int result = findTargetSumWay.findTargetSumWays1(nums, s);
        System.out.println("result: "+result);


    }
}
