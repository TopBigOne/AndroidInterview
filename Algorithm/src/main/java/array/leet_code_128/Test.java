package array.leet_code_128;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/16 20:20
 * @Url :
 * @Level : easy medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int result = longestConsecutive.longestConsecutive(nums);
        System.out.println("result : " + result);
    }
}
