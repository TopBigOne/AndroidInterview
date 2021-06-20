package back_tracking.leet_code_78;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author : dev
 * @version :
 * @Date :  6/20/21 6:46 PM
 * @Desc :  leetcode 78 ： 子集：https://leetcode-cn.com/problems/subsets/
 * <p>
 * 题解： 使用位运算
 * 1： weiwei：https://leetcode-cn.com/problems/subsets/solution/hui-su-python-dai-ma-by-liweiwei1419/
 */
public class SubsetByBit {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        SubsetByBit subsetByBit = new SubsetByBit();
        List<List<Integer>> result = subsetByBit.subsets(nums);
        result.forEach(integers -> System.out.println("sub: " + integers));
    }

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int size = 1 << len;
        System.out.println("size : "+size);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (((i >> j) & 1) == 1) {
                    subset.add(nums[j]);
                }
            }
            res.add(subset);
        }
        return res;
    }
}
