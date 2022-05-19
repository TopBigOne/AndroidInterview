package array.interview.merge_10_01;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/15 18:25
 * @Desc :  https://leetcode.cn/problems/sorted-merge-lcci/
 */
public class Merge {


    /**
     * @param A 原数组
     * @param m
     * @param B 原数组
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int indexA = m - 1;
        int indexB = n - 1;

        while (indexA >= 0 && indexB >= 0) {

            int tempIndex = indexA + indexB + 1;

            if (B[indexB] >= A[indexA]) {
                //从数组B获取
                A[tempIndex] = B[indexB];
                indexB--;
            } else {
                //
                A[tempIndex] = A[indexA];
                indexA--;
            }
        }


        // 如果B剩下，就将B数组的元素，一一插入数组A中
        while (indexB >= 0) {
            A[indexB] = B[indexB];
            indexB--;
        }
    }

    public void merge2(int[] A, int m, int[] B, int n) {
        int indexA = m - 1;
        int indexB = n - 1;
        while (indexA >= 0 && indexB >= 0) {
            int targetIndex = indexA + indexB + 1;

            if (B[indexB] > A[indexA]) {
                A[targetIndex] = B[indexB];
                indexB--;

            } else {
                A[targetIndex] = A[indexA];
                indexA--;
            }
        }
        while (indexB >= 0) {
            A[indexB] = B[indexB];
            indexB--;

        }

    }

}
