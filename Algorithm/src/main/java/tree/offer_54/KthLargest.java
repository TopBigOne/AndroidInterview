package tree.offer_54;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/6 22:32
 * @Desc : https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/
 */
public class KthLargest {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        int result = res.get(res.size() - k);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }


}
