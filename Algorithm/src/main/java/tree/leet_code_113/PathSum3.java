package tree.leet_code_113;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 11:54
 * @Desc :
 */
public class PathSum3 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        help(root,targetSum,path,res);
        return res;
    }

    private void help(TreeNode root, int targetSum, Deque<Integer> path, List<List<Integer>> res) {
        if(root==null){
            return;
        }
        targetSum-=root.val;
        path.addLast(root.val);
        if(targetSum==0 && root.left ==null && root.right== null){
            res.add(new ArrayList<>(path));
            //backtrack
            path.removeLast();
            return;
        }
        help(root.left,targetSum,path,res);
        help(root.right,targetSum,path,res);
        path.removeLast();
    }


}
