package array.leet_code_31;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/15 15:15
 * @Url :
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class NextPermutation5 extends Base {

    public void nextPermutation(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return;
        }

        int index = len - 2;
        // 1：找到那个突然降低的点；
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        if (index >= 0) {
            // 在 [index+1，len-1],找到一个nums[k]>nums[index]的值，返回它
            // 的下标j；
            int j = binarySearch(nums, index + 1, len - 1, nums[index]);
            // 做交换
            swap(nums, index, j);
        }

        // 把index+1 到len-1 段的数组，做一下升序
        doPartReverse(nums, index + 1, len - 1);
    }

    private void doPartReverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, i--);
        }
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int curValue = nums[mid];
            if (curValue > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;

    }


}
