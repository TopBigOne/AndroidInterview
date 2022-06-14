package array.sub_array.leet_code_907;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/14 13:27
 * @Desc : 子数组的最小值之和 :https://leetcode.cn/problems/sum-of-subarray-minimums/
 */
public class SumSubArrayMin {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        SumSubArrayMin sumSubArrayMin = new SumSubArrayMin();
        int result = sumSubArrayMin.sumSubarrayMins(arr);
        System.err.println("result : " + result);
    }

    /**
     * @param arr arr = [3,1,2,4]
     * @return
     */
    public int sumSubarrayMins(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int depth = 0;
        boolean[] used = new boolean[arr.length];
        dfs(arr, depth, path, used, result);
        System.err.println("result : " + result);
        return 0;
    }

    private void dfs(int[] arr, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (depth == arr.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // 防止重复
            if (used[i]) {
                continue;
            }

            used[i] = true;
            path.addLast(arr[i]);
            dfs(arr, depth + 1, path, used, result);
            path.removeLast();
            used[i] = false;
        }
    }
}
