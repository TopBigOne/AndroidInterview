package sort.merge_sort;

/**
 * @author : dev
 * @version :
 * @Date :  6/27/21 12:43 PM
 * @Desc : 归并排序:https://leetcode-cn.com/problems/sort-an-array/solution/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/
 * <p>
 * 基本思路：借助额外空间，合并两个有序数组，得到更长的有序数组，例如：leet code 88: 合并两个有序数组
 * 归并排序是理解【递归思想】的非常好的学习资料，大家可以通过理解：递归完成以后，合并两个有序数组的这一步骤，想清楚程序的执行流程。即：递归函数执行完成以后：
 * 我们还可以做点事情；因此：【归并排序】：一定要掌握
 */
public class MergeSort {
    public static void main(String[] args) {
    }

    /**
     * 列表啊小于或者等于 7，将优先使用插入排序
     */
    public static final int INSERT_SORT_THRESHOLD = 7;

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }

    /**
     * 对数组 nums 的子区间 [left,right]进行归并排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp  用于合并两个有序数组的辅助数组，全局使用一份，避免多次创建和销毁
     */
    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        // 小区间使用插入排序
        if (right - left <= INSERT_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
       // int mid = left + (right - left) >> 1;
        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        // 如果数组的这个子区间本身有序，就不需要合并
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }

    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }

    }

    /**
     * 合并 2 个已经排了序列的数组；先把值copy 到临时数组，再合并回去
     *
     * @param nums
     * @param left
     * @param mid   [left,mid] 有序，[mid+1,right]有序
     * @param right
     * @param temp  全局使用的临时数组
     */
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right + 1 - left);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 注意写成< 就丢失了稳定性（相同元素原来靠前的排序以后，依然靠前)
                nums[k] = temp[i];
                i++;
            } else {
                // temp[i]>temp[j]
                nums[k] = temp[j];
                j++;
            }
        }
    }


}
