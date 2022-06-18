package tree.leet_code_1305;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/2 18:25
 * @Desc :
 */
public class GetAllElements {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();


        inorder(root1, l1);
        inorder(root2, l2);

        int m = l1.size();
        int n = l2.size();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            int temp = l1.get(i) < l2.get(j) ? l1.get(i++) : l2.get(j++);
            res.add(temp);
        }

        if (i < m) {
            res.addAll(l1.subList(i, m));
        }
        if (j < n) {
            res.addAll(l2.subList(j, n));
        }


        return res;
    }

    private void inorder(TreeNode root, List<Integer> l1) {
        if (root == null) {
            return;
        }
        inorder(root.left, l1);
        l1.add(root.val);
        inorder(root.right, l1);
    }


}
