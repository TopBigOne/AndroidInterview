package tan_xin.leet_code_881;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  6/18/21 1:11 AM
 * @Desc :  救生艇：https://leetcode-cn.com/problems/boats-to-save-people/solution/
 * <p>
 * 题解： https://leetcode-cn.com/problems/boats-to-save-people/solution/881-jiu-sheng-ting-by-bengdiwang/
 */
public class NumRescueBoats {
    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3};
    }

    public int numRescueBoats2(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int res = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            res++;
        }
        return res;
    }


}
