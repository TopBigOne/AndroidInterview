package sort.quick_sort;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/23 17:48
 * @Url :
 * @Level :    medium
 * @Desc : 将奇数 放在左边，偶数放在右边，面试，会聊这个；
 * @Counter :
 * @Answer :
 */
public class SortArrayByParity_Interview {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 15, 16, 17};
        sort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    }

    public static void sort(int[] arr) {
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] % 2 == 1) {
                swap(j, i, arr);
                i++;
            }
        }
    }

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
