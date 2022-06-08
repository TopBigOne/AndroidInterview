package top_k.leet_code_215.base;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/5/31 17:37
 * @Url :
 * @Level : easy medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class BaseFun {
    /**
     *  数组中，两两交换
     *
     * @param nums
     * @param index1
     * @param index2
     */
    protected void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    protected void print(String tag, Object value) {
        if (value == null) {
            return;
        }
        tag = tag+" : ";
        if (value.getClass().isArray()) {
            System.out.println(tag + Arrays.toString((int[]) value));
            return;
        }
        System.out.println(tag + value);
    }

}
