package dp.sub_sequence.leet_code_300;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/21 19:09
 * @Desc :
 * <p>
 * 题解：https://labuladong.github.io/algo/3/24/74/
 */
public class LengthOfLIS6 {
    /**
     * 二分查找的方式
     *
     * @param nums
     * @return
     */
    int lengthOfLIS(int[] nums) {

        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        for (int poker : nums) {
            // 要处理的扑克牌
            // 搜索左侧边界的二分查找
            int left = 0;
            int right = piles;

            while (left < right) {
                int mid = (left + right) >> 1;

                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }

            }

            // 没找到合适的牌堆，新建一堆
            if (left == piles) {
                piles++;
            }
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }

}
