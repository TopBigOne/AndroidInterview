package back_tracking.leet_code_78;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  7/31/21 1:23 AM
 * @Desc :leet-78 子集：https://leetcode-cn.com/problems/subsets/
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subset3 {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> reuslt = new ArrayList<>();
        if (len == 0) {
            return reuslt;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, path, reuslt);
        return reuslt;
    }

    private void dfs(int[] nums, int len,int depth,Deque<Integer> path,List<List<Integer>> result){
        if(len==depth){
            result.add(new ArrayList<>(path));
            return;
        }
        // 不选择
        dfs(nums,len,depth+1,path,result);

        // 选择
        path.addLast(nums[depth]);
        dfs(nums,len,depth+1,path,result);
        path.removeLast();

    }
}
