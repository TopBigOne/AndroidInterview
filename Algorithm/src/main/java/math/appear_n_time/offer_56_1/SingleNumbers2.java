package math.appear_n_time.offer_56_1;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/12 16:17
 * @Desc :
 */
public class SingleNumbers2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 5};
        SingleNumbers2 singleNumbers = new SingleNumbers2();
        int[] result = singleNumbers.singleNumbers(nums);
        System.err.println("result : " + Arrays.toString(result));
    }

    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }

        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }

        System.out.println(" div : " + div);

        int m = 0;
        int n = 0;
        for (int num : nums) {
            if ((div & num) != 0) {
                m ^= num;
            } else {
                n ^= num;
            }
        }

        return new int[]{m, n};

    }

    public int[] singleNumbers2(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }

        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }

        int m = 0;
        int n = 0;
        for (int num : nums) {
            if ((div & num) != 0) {
                m ^= num;
            } else {
                n ^= num;
            }
        }

        return new int[]{m, n};


    }

}
