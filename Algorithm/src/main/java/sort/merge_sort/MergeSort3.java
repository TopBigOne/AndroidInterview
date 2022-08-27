package sort.merge_sort;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/27 15:37
 * @Desc :
 */
public class MergeSort3 {

    int INSERT_THRESHOLD = 7;

    public int[] sortArray(int[] nums) {
        int right = nums.length - 1;
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, right, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (right - left <= INSERT_THRESHOLD) {
            insertSort(nums, left, right);
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right, temp);

    }

    private void insertSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int leftValue = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > leftValue) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = leftValue;
        }
    }

    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        if (right - left >= 0) {
            System.arraycopy(nums, left, temp, left, right - left + 1);
        }
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
                nums[k] = temp[i];
                i++;
            } else if (temp[i] > temp[j]) {
                nums[k] = temp[j];
                j++;
            }

        }

    }


}
