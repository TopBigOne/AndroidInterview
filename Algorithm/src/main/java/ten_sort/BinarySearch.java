package ten_sort;

import java.util.Arrays;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-15 10:38
 * @Desc : 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] rawData = {12, 4, 6, 2, 7, 1, 3, 8};
        Arrays.sort(rawData);
        System.out.println(" after sort arr:" + Arrays.toString(rawData));
        int index = getIndex4(12, rawData);
        System.out.println("index:" + index);
    }

    /**
     * @param key
     * @param rawData 数组必须是有序的。
     * @return
     */
    private static int rank(int key, int[] rawData) {
        int lo = 0;
        int hi = rawData.length - 1;
        while (lo <= hi) {
            //  被查找的键要么不存在，要么必然存在于 a[o...hi] 之中；
            int mid = lo + (hi - lo) >> 1;

            // 与中间的那个数比较
            if (key < rawData[mid]) {
                // 左边找
                hi = mid - 1;
            } else if (key > rawData[mid]) {
                // 右边找
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }


    private static int getTargetIndex(int target, int[] rawData) {
        int lo = 0;
        int hi = rawData.length - 1;
        while (lo <= hi) {
            //  每次取中间值
            int mid = lo + (hi - lo) / 2;
            if (target < rawData[mid]) {
                hi = mid - 1;
            } else if (target > rawData[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }

        }

        return -1;
    }


    private static int getIndex2(int target, int[] rawData) {
        int low = 0;
        int high = rawData.length - 1;
        while (low <= high) {
            int mid = low + (high - low) >> 1;
            if (target < rawData[mid]) high = mid - 1;
            else if (target > rawData[mid]) low = mid + 1;
            else return mid;
        }

        return -1;
    }

    private static int getIndex3(int target, int[] rawData) {
        int low = 0;
        int high = rawData.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target < rawData[mid]) high = mid - 1;
            else if (target > rawData[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }


    private static int getIndex4(int target, int[] rawData) {
        int low = 0;
        int high = rawData.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target <= rawData[mid]) high = mid - 1;
            if (target > rawData[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }

    private static int getIndex5(int target, int[] rawData) {
        int low = 0;
        int high = rawData.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target <= rawData[mid]) {
                high = mid - 1;
            } else if (target > rawData[mid]) {
                low = mid + 1;
            } else return mid;
        }

        return -1;
    }


}
