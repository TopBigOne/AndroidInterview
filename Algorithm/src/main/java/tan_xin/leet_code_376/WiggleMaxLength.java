package tan_xin.leet_code_376;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/11/16 23:26
 * @Url : https://leetcode.cn/problems/wiggle-subsequence/solutions/?orderBy=most_votes
 * @Level :    medium
 * @Desc :  摆动序列：
 * @Counter :
 * @Answer : 题解：https://leetcode.cn/problems/wiggle-subsequence/solutions/284327/tan-xin-si-lu-qing-xi-er-zheng-que-de-ti-jie-by-lg/?orderBy=most_votes
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int down = 1;
        int up = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }

        }
        return nums.length == 0 ? 0 : Math.max(down, up);

    }
}
