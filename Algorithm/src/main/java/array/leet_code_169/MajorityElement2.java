package array.leet_code_169;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/2 17:23
 * @Desc :
 */
public class MajorityElement2 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;

        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (res != num) {
                count--;
            } else {
                count++;
            }
        }
        return res;

    }

    public int majorityElement2(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (res != num) {
                count--;
            } else {
                count++;
            }
        }

        return res;
    }
}
