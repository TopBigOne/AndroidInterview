package sort.merge_sort.offer_51;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/12 15:39
 * @Desc :
 */
public class ReversePair_MergeSort5 {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] copy = new int[len];
        int[] helpArray = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);
        return reversePairs(copy, 0, len - 1, helpArray);
    }

    private int reversePairs(int[] nums, int left, int right, int[] helpArray) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;// >>;
        int leftCount = reversePairs(nums, left, mid, helpArray);
        int rightCount = reversePairs(nums, mid + 1, right, helpArray);
        int crossCount = mergeAndCalculate(nums, left, mid, right, helpArray);
        return leftCount + rightCount + crossCount;
    }


    private int mergeAndCalculate(int[] nums, int left, int mid, int right, int[] helpArray) {
        if (right - left + 1 >= 0) {
            System.arraycopy(nums, left, helpArray, left, right - left + 1);
        }

        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = helpArray[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = helpArray[i];
                i++;

            } else if (helpArray[i] <= helpArray[j]) {
                nums[k] = helpArray[i];
                i++;

            } else if (helpArray[i] > helpArray[j]) {
                nums[k] = helpArray[j];
                j++;
                count += (mid - i + 1);
            }
        }

        return count;
    }

    private int mergeAndCalculate2(int[] nums, int left, int mid, int right, int[] helpArray) {
        if (right - left + 1 > 0) {
            System.arraycopy(nums, left, helpArray, left, right - left + 1);
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            // 处理i ,j越界问题；
            if (i == mid + 1) {
                nums[i] = helpArray[j];
                j++;

            }
            if (j == right + 1) {
                nums[i] = helpArray[i];
                i++;
            }

            if (helpArray[i] <= helpArray[j]) {
                nums[i] = helpArray[i];
                i++;
            } else if (helpArray[i] > helpArray[j]) {
                nums[i] = helpArray[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;


    }

}
