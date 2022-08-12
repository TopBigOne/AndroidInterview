package sort.merge_sort.offer_51;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/12 11:44
 * @Desc :
 */
public class ReversePair_MergeSort3 {

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] copy = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);

        int[] helpArray = new int[len];
        return reversePairs(copy, 0, len - 1, helpArray);
    }

    private int reversePairs(int[] nums, int left, int right, int[] helpArray) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, helpArray);
        int rightPairs = reversePairs(nums, mid + 1, right, helpArray);
        int crossPairs = mergeAndCount(nums, left, mid, right, helpArray);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] helpArray) {
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
            } else {
                nums[k] = helpArray[j];
                j++;
                // 做统计
                count += (mid - i + 1);
            }
        }
        return count;
    }

    private int mergeAndCount2(int[] nums, int left, int mid,
                               int right, int[] helpArray) {
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
            } else {
                nums[k] = helpArray[j];
                count += mid - i + 1;
            }


        }
        return count;
    }

    private int mergeAndCount3(int[] nums, int left, int mid,
                               int right, int[] helpArray) {
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

            } else if (helpArray[i] == helpArray[j]) {
                nums[k] = helpArray[i];
                i++;
            } else {
                nums[k] = helpArray[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }

    private int mergeAndCount4(int[] nums, int left, int mid,
                               int right, int[] helpArray) {

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

            } else {
                nums[k] = helpArray[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }

}
