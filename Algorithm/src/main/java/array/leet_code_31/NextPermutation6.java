package array.leet_code_31;


/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/16 11:31
 * @Url :
 * @Level :    medium
 * @Desc : 下一个全排列
 * @Counter :
 * @Answer :
 */
public class NextPermutation6 extends Base {
    public void nextPermutation(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return;
        }

        int index = len - 2;
        while (index >= 0 && nums[index] > nums[index + 1]) {
            index--;
        }
        if (index >= 0) {
            int j = binarySearch(nums, index + 1, len - 1, nums[index]);
            swap(nums, index, len - 1);
        }

        doPartReverse(nums, index + 1, len - 1);
    }


    public int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private void doPartReverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }




}
