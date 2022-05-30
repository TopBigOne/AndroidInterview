package binary_search.offer_11;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/28 21:06
 * @Desc : 旋转数组的最小值
 * 题解：https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/er-fen-jian-zhi-si-xiang-fen-zhi-si-xiang-by-liwei/
 * 视频题解：https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/pei-yang-suan-fa-si-wei-cong-bao-li-dao-37iuz/
 */
public class MinArray3 {

    /**
     * 思路，主要是通过 mid index 所对应的value 和 right index 所对应的value 进行比较；
     * case 1: when mid value  more than right value ----> l = mid+1;
     * case 2: when mid value  less than right value -----> r = mid;
     * case 3: when mid  value == right value = r = r-1;
     *
     * @param nums
     * @return
     */
    public int minArray(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int midValue = nums[mid];
            int rightValue = nums[r];
            if (midValue > rightValue) {
                l = mid + 1;
                continue;
            }
            if (midValue < rightValue) {
                r = mid;
            }
            if (midValue == rightValue) {
                r = r - 1;

            }
        }
        return nums[l];
    }

}
