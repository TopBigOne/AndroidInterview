package array.leet_code_977;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/11 23:04
 * @Level :  easy
 * @Url :
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        SortedSquares sortedSquares = new SortedSquares();
        int[] result = sortedSquares.sortedSquares(nums);
        System.out.println("result :"+ Arrays.toString(result));
    }

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = (int) Math.pow(nums[i], 2);
            nums[i] = temp;
        }
        Arrays.sort(nums);

        return nums;

    }
}
