package ten_sort.merge_sort.offer_51;

/**
 * @author : dev
 * @version :
 * @Date :  6/27/21 6:29 PM
 * @Desc :  https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * <p>
 * <p>
 * 题解：https://www.youtube.com/watch?v=kvXPpFP9sXg
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/bao-li-jie-fa-fen-zhi-si-xiang-shu-zhuang-shu-zu-b/
 */
public class ReversePair_MergeSort2 {

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int[] copy = new int[len];

        System.arraycopy(nums, 0, copy, 0, len);

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left ...mid] 有序，nums[mid+1...right] 有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        if (right + 1 - left >= 0) {
            System.arraycopy(nums, left, temp, left, right + 1 - left);
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            }
            // 如果不加上= ，归并排序就不是一个稳定的排序
            else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;

                count += (mid - i + 1);
            }
        }

        return count;
    }


}
