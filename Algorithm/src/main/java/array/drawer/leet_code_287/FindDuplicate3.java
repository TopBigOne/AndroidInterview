package array.drawer.leet_code_287;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/26 14:53
 * @Desc :
 */
public class FindDuplicate3 {


    public static void main(String[] args) {
        FindDuplicate3 findDuplicate = new FindDuplicate3();
        int[] nums = {7, 9, 7, 4, 2, 8, 7, 7, 1, 5};
        int result = findDuplicate.findDuplicate(nums);
        System.out.println("result :" + result);

    }

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 因为数组不是有序的，所以
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count += 1;
                }
            }

            System.out.println("数组    : " + Arrays.toString(nums));
            System.out.println("left    : " + left);
            System.out.println("right   : " + right);

            System.out.println("count   : " + count);
            System.out.println("mid     : " + mid);

            System.out.println("--------------------");

            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }
}
