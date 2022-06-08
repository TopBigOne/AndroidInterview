package sort.merge_sort.offer_51;

/**
 * @author : dev
 * @version :
 * @Date :  6/27/21 2:22 PM
 * @Desc :  数组中的逆序对，字节半年 10 次  https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class ReversePair_Default {
    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        ReversePair_Default reversePairDefault = new ReversePair_Default();
        int result = reversePairDefault.reversePairs(nums);
        System.out.println("result: " + result);
    }

    /**
     * 暴力解法
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int cnt = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int front = nums[i];
                int behind = nums[j];
                System.out.println(" front  : " + front + ", behind : " + behind);
                if (front > behind) {
                    cnt++;
                }
            }
            System.out.println("|----------------------------------------|");
        }
        return cnt;
    }

}
