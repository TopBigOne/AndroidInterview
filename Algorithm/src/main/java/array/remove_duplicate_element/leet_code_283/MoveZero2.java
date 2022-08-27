package array.remove_duplicate_element.leet_code_283;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/18 10:12
 * @Desc :
 * 题解：一姐：
 * https://www.bilibili.com/video/BV1Pv4y1Z76N?spm_id_from=333.999.0.0&vd_source=48ebba24d97534cb7fc891ea4972fffa
 */
public class MoveZero2 {
    public void moveZeroes(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return;
        }
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[start] = nums[i];
                start++;
            }
        }

        for (int i = start; i < len; i++) {
            nums[start] = 0;

        }

    }
}
