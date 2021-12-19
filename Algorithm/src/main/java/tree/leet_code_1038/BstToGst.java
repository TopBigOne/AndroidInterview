package tree.leet_code_1038;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/20 00:02
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/solution/1038-cong-er-cha-sou-suo-shu-dao-geng-da-he-shu-fa/
 */
public class BstToGst {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return root;
        }
        bstToGst(root.right);
        sum = sum + root.val;
        root.val = sum;
        bstToGst(root.left);


        return root;


    }

}
