package array.leet_code_27;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/8/2 11:01
 * @Url :
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :  https://leetcode-cn.com/problems/remove-element/
 * <p>
 * 关注业务，更要看重结果，有时候，从结果出发，反推逻辑，问题变得就简单了，
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] raws = {3, 5, 7, 2, 6, 1, 7, 7};

        System.out.println("before : " + Arrays.toString(raws));
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(raws,7);
        System.out.println("after  : " + Arrays.toString(raws));


    }

    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for (int num : nums) {
            if (num != val) {
                nums[ans] = num;
                ans++;
            }
        }
        return ans;

    }
}
