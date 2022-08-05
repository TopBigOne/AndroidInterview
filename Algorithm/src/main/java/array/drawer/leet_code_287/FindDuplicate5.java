package array.drawer.leet_code_287;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/5 18:14
 * @Desc :
 */
public class FindDuplicate5 {
    public int findDuplicate(int[] nums) {
        int[] count = new int[nums.length + 1];

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 0; i < count.length; i++) {

            if (count[i] > 1) {
                return i;
            }
        }
        return 0;
    }
}
