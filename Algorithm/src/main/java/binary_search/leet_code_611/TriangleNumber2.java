package binary_search.leet_code_611;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/8 17:18
 * @Desc :
 */
public class TriangleNumber2 {
    public static void main(String[] args) {
        int[] num = {2, 3, 4, 4};
        TriangleNumber2 triangleNumber = new TriangleNumber2();
        int count = triangleNumber.triangleNumber(num);
        System.err.println("count : " + count);

    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i - 1; j > 0; j--) {
                for (int k = j; k > 0; k--) {

                    int one = nums[i];
                    int two = nums[j];
                    int three = nums[k];

                    System.err.println(" one : " + one);
                    System.err.println(" two : " + two);
                    System.err.println(" three : " + three);
                    System.err.println("--------------|");
                    if (one + two >= three) {
                        res++;
                    }
                }

            }

        }
        return res;
    }
}
