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
        int[] rawData = {12, 4, 6, 2, 7, 8, 3, 1, 6};
        Arrays.sort(rawData);
        System.out.println(" after sort arr:" + Arrays.toString(rawData));
        int index = rank(6, rawData);
        System.out.println("index:" + index);
    }


    /**
     * @param key
     * @param rawData 数组必须是有序的。
     * @return
     */
    public static int rank(int key, int[] rawData) {
        int lo = 0;
        int hi = rawData.length - 1;
        while (lo <= hi) {
            //  被查找的键要么不存在，要么必然存在于 a[o...hi] 之中；
            int mid = lo + (hi - lo) / 2;

            // 与中间的那个数比较
            if (key < rawData[mid]) {
                hi = mid - 1;
            } else if (key > rawData[mid]) {
                hi = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
