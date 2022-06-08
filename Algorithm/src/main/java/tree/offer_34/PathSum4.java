package tree.offer_34;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/6 19:31
 * @Desc :
 */
public class PathSum4 {

    public List<List<Integer>> pathSum(TreeNode root, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        preOrder(root, target, path, res);

        return res;


    }

    private void preOrder(TreeNode root, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        int currValue = root.val;

        path.add(currValue);

        target -= currValue;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }

        preOrder(root.left, target, path, res);
        preOrder(root.right, target, path, res);
        path.removeLast();

    }


}
