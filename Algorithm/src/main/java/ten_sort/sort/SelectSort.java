package ten_sort.sort;

import java.util.Arrays;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-29 10:23
 * @Desc :
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 4, 5, 9, 0, 6};
        sortData1(arr);
        sortData2(arr);

        System.out.println("sort result:" + Arrays.toString(arr));
    }

    private static void sortData2(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < length; j++) {



            }

        }


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
