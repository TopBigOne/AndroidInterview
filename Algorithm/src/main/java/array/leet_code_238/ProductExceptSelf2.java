package array.leet_code_238;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/10/22 23:11
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ProductExceptSelf2 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        // left to right
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // right to left;
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];

        }
        return res;
    }
}
