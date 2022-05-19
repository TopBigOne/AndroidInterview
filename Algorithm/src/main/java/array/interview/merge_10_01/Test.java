package array.interview.merge_10_01;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/15 19:41
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        int m = 3;
        int n = 3;

        Merge merge = new Merge();
        merge.merge(A, m, B, n);


    }
}
