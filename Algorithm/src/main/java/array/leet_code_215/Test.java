package array.leet_code_215;

/**
 * @author : dev
 * @version :
 * @Date :  5/31/21 11:46 AM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        int[] raw = {3, 2, 1, 5, 6, 4};
        int k = 2;
        FindKthLargest findKthLargest = new FindKthLargest();
        int result = findKthLargest.findKthLargest(raw, k);
        System.out.println("result: " + result);
    }
}
