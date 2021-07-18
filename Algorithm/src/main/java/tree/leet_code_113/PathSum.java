package tree.leet_code_113;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.TooManyListenersException;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/14 11:34
 * @Desc :  字节半年 9次：路径总和：https://leetcode-cn.com/problems/path-sum-ii/solution/
 *  回溯算法的体现
 * 题解：https://leetcode-cn.com/problems/path-sum-ii/solution/hui-su-suan-fa-shen-du-you-xian-bian-li-zhuang-tai/
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        pathSum(root, sum, path, res);
        return res;
    }

    private void pathSum(TreeNode root, int sum, Deque<Integer> path,
                         List<List<Integer>> res) {
        // 递归终止条件，1：遇到空节点，
        if (root == null) {
            return;
        }
        sum -= root.val;
        path.add(root.val);
        // 递归终止条件，2：遇到叶子节点，sum 恰好为0，说明从根节点到叶子节点的路径是一个符合要求的解
        if (sum == 0 && root.left == null && root.right == null) {
            // path 全局只有一份，必须做拷贝
            res.add(new ArrayList<>(path));
            // 注意，这里return必须重置
            path.removeLast();
            return;
        }
        pathSum(root.left, sum, path, res);
        pathSum(root.right, sum, path, res);
        path.removeLast();

    }

    /**
     *
     * @param root
     * @param sum
     * @param path 可以转换成 List 集合的；这个要记住哦；
     * @param res
     */
    private void pathSum2(TreeNode root,int sum,Deque<Integer> path,List<List<Integer>> res){
        if (root == null) {
            return;
        }

        sum -=root.val;
        path.add(root.val);
        if(sum==0&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        pathSum2(root.left,sum,path,res);
        pathSum2(root.right,sum,path,res);
        // 减枝操作
        path.removeLast();

    }

    private  void pathSum3(TreeNode root,int sum,Deque<Integer> path,List<List<Integer>> res){
        if (root==null) {
            // 1：在处理过程中，root 直接就是空了，需要终止递归操作
            return;
        }
        sum-= root.val;
        path.add(root.val);
        if(sum==0&&root.left==null&&root.right==null){

            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        pathSum3(root.left,sum,path,res);
        pathSum3(root.right,sum,path,res);
        path.removeLast();
    }




}
