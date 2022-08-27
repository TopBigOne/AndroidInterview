package tree.leet_code_257;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  4/16/21 12:38 AM
 * @Desc :
 * <p>
 * 题解：https://leetcode-cn.com/problems/binary-tree-paths/solution/bie-wen-wen-jiu-shi-dfs-by-lyl0724-2/https://leetcode-cn.com/problems/binary-tree-paths/solution/bie-wen-wen-jiu-shi-dfs-by-lyl0724-2/
 */
public class BinaryTreePath2 {
    private List<String> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        preOrder(root);
        return res;

    }
    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder temp = new StringBuilder();
            int size = path.size();
            for (int i = 0; i < size; i++) {
                temp.append(path.get(i));
                if (i != size - 1) {
                    temp.append("->");
                }
            }
            res.add(temp.toString());
        }
        preOrder(root.left);
        preOrder(root.right);
        path.removeLast();
    }

}
