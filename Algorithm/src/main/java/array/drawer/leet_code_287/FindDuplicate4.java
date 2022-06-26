package array.drawer.leet_code_287;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/26 16:01
 * @Desc :
 */
public class FindDuplicate4 {

    public static void main(String[] args) {
        FindDuplicate4 findDuplicate = new FindDuplicate4();
        int[] nums = {7, 9, 7, 4, 2, 8, 7, 7, 1, 5};
        int result = findDuplicate.findDuplicate(nums);
        System.out.println("result :" + result);

    }

    /**
     * 桶排序-用空间换时间
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int[] count = new int[nums.length + 1];
        for (int num : nums) {
            count[num]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                return i;
            }
        }
        return 0;

    }
}
