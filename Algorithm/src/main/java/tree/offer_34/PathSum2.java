package tree.offer_34;

import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/15 21:01
 * @Desc :
 */
public class PathSum2 {
    private final LinkedList<List<Integer>> res = new LinkedList<>();
    private final LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return res;
    }

    private void recur(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        recur(root.left, target);
        recur(root.right, target);
        path.removeLast();

    }

    private void recur2(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        recur(root.left, target);
        recur(root.right, target);
        path.removeLast();

    }


}
