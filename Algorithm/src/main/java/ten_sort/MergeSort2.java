package ten_sort;


/**
 * @author : dev
 * @version :
 * @Date :  12/9/21 11:20 PM
 * @Desc : https://leetcode-cn.com/problems/sort-an-array/submissions/
 */
public class MergeSort2 {

    int INSERT_SORT_THRESHOLD = 7;

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;

    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (right - left <= INSERT_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
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
     * 合并 2 个已经排了序列的数组
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
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
            } else if (temp[i] < temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
    }


}
