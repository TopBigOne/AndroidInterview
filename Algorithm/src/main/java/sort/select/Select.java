package sort.select;

import sort.BaseOperation;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-29 10:23
 * @Desc :
 * https://www.bilibili.com/video/BV1Jg411M7Lp?spm_id_from=333.337.search-card.all.click&vd_source=48ebba24d97534cb7fc891ea4972fffa
 */
public class Select extends BaseOperation {
    public static void main(String[] args) {
    }
    private  void sortData2(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j]<arr[minIndex]){
                    minIndex =j;
                }
            }

           swap(arr,minIndex,i);
        }
        printResult(arr);
    }

    private  void sortData1(int[] arr) {
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
