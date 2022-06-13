package array.find_duplicate;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/5/14 14:13
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Base {
    /**
     * 利用异或运算交换数据
     *
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];

    }


}
