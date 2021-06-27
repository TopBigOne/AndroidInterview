package ten_sort.sort;

/**
 * @author : Jakarta
 * @version :
 * @Date : 7/1/20 7:59 PM
 * @Desc :冒泡排序
 */
public class BubbleSort extends BaseSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 4, 5, 9, 0, 6};
        sortData(arr);

    }

    private static void sortData(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        printResult("bubble one: ", arr);
    }

}
