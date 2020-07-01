package ten_sort.sort;

import java.util.Arrays;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-29 10:23
 * @Desc :
 */
public class SelectSort extends BaseSort {
    public static void main(String[] args) {
        sortData1(arr);
        sortData2(arr);
    }
    private static void sortData2(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < length; j++) {
                minPos = arr[j]<arr[minPos] ? j:minPos;

            }
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
        printResult(arr);
    }

    private static void sortData1(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            // swap...
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }
}
