package math.leet_code_485;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/10/27 20:27
 * @Url :
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :
 * <p>
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 */
public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
        int [] nums = {1,1,0,1,1,1} ;
        FindMaxConsecutiveOnes findMaxConsecutiveOnes = new FindMaxConsecutiveOnes();
        int result  = findMaxConsecutiveOnes.findMaxConsecutiveOnes(nums);
        System.err.println("result : "+result);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count += 1;
            } else {
                count = 0;
            }
            max = Math.max(max,count);
        }
        return max;

    }
}
