package back_tracking.leet_code_78;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author : dev
 * @version :
 * @Date :  6/20/21 8:39 PM
 * @Desc :
 */
public class Subset2 {
    public static void main(String[] args) {
        Subset2 subset2 = new Subset2();
        int [] nums = new int[]{1,2,3};
        List<List<Integer>> result = subset2.subset(nums);
        result.forEach(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) {
                System.out.println(integers);
            }
        });

    }

    public List<List<Integer>> subset(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(nums, len, 0, stack, res);
        return res;
    }

    /**
     * @param nums
     * @param len
     * @param index 理解成path
     * @param stack
     * @param res
     */
    private void dfs(int[] nums, int len, int index, Deque<Integer> path, List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }


        // 不选择
        dfs(nums, len, index + 1, path, res);

        // 考虑这个元素
        path.addLast(nums[index]);
        // 下一层递归
        dfs(nums, len, index + 1, path, res);
        path.removeLast(); // 状态重置


    }
}
