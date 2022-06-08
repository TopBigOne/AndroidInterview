package tree.offer_34;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version : 剑指 Offer 34. 二叉树中和为某一值的路径 :https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/submissions/
 * @Date :  2022/6/6 19:22
 * @Desc :
 */
public class PathSum3 {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        preOrder(root, target, path, res);
        return res;
    }

    /**
     * 前序遍历
     *
     * @param root   节点
     * @param target 目标值
     * @param path   回溯路径
     * @param res    结果
     */
    private void preOrder(TreeNode root, int target, LinkedList<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        int curValue = root.val;
        path.add(curValue);
        target -= curValue;
        // 添加结果的
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        preOrder(root.left, target, path, res);
        preOrder(root.right, target, path, res);
        path.removeLast();
    }


}
