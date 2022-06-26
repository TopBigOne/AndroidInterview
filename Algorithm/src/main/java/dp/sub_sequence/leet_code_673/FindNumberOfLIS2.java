package dp.sub_sequence.leet_code_673;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/21 00:49
 * @Desc :
 */
public class FindNumberOfLIS2 {

    public int findNumberOfLIS(int[] nums) {

        int len = nums.length;

        int count = 0;
        // [1,3,5,4,7]
        for (int i = 0; i < len; i++) {
            // [1,3,5,4,7]
            for (int j = 1; j < len; j++) {
                if (nums[j] > nums[i]) {

                } else {

                }


            }

        }


        return 0;

    }
}
