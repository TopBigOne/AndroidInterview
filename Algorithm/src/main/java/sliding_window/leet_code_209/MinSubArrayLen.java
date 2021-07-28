package sliding_window.leet_code_209;

/**
 * @author : dev
 * @version :
 * @Date :  6/27/21 11:58 PM
 * @Desc : leetcode 209 长度最小的子数组 字节 7 次   https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int lo = 1, hi = nums.length, min = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (windowExist(mid, nums, s)) {
                hi = mid - 1;//找到就缩小窗口的大小
                min = mid;//如果找到就记录下来
            } else
                lo = mid + 1;//没找到就扩大窗口的大小
        }
        return min;
    }

    //size窗口的大小
    private boolean windowExist(int size, int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size)
                sum -= nums[i - size];
            sum += nums[i];
            if (sum >= s)
                return true;
        }
        return false;
    }




}
