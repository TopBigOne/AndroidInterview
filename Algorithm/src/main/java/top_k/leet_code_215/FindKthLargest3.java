package top_k.leet_code_215;

import top_k.leet_code_215.base.BaseFun;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/5/31 17:19
 * @Url :
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class FindKthLargest3 extends BaseFun {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }


    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        print("pivot", pivot);

        int j = left;

        for (int i = left + 1; i <= right; i++) {
            int currValue = nums[i];
            if (currValue < pivot) {
                j++;
                // 比pivot 小的，放在pivot的左边；
                // 看一下，比3小的，都放在了3的左边；
//                tag : [3, 2, 1,   5, 6, 4]
//                tag : [3, 2, 1,   5, 6, 4]
//                tag : [3, 2, 1,   5, 6, 4]
//                tag : [3, 2, 1,  5, 6, 4]
//                tag : [1, 2, 3,  5, 6, 4]
//                tag : [1, 2, 3,  5, 4, 6]
                swap(nums, j, i);
            }
           //  print("currValue < pivot 遍历结果：", nums);
        }

        swap(nums, j, left);
        print("partition 遍历结果：", nums);
        return j;
    }
}
