package tree.leet_code_235;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/15/21 7:54 PM
 * @Desc : 二叉搜索树的最近公共祖先（https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/）
 * <p>
 * 解法：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/zi-jie-ti-ku-235-jian-dan-er-cha-sou-suo-shu-de-zu/
 * 方法一：递归 + 利用 BST 的特性。
 * 如果 p 或 q 等于 root，返回 p 或 q；
 * 如果 p 和 q 都大于 root 的值，向右子树递归；
 * 反之向左子树递归；
 * 如果都不是，说明 p 和 q 在 root 的一左一右，返回 root。
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        return search(root, p, q);
    }

    private TreeNode search(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res;
        if (p == root || q == root) {
            res = p == root ? p : q;
        } else if (p.val > root.val && q.val > root.val) {
            res = search(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            res = search(root.left, p, q);
        } else {
            res = root;
        }
        return res;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // base
        if (root == null) {
            return null;
        }
        // 如果 root 本身就是p 或者 q，那么root 就是最近公共祖先；
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        // post--start
        // 情况 1 : 如果 p 和 q都在 root 为根的树中，那么 left 和 right 一定分别是 p 和 q （从base case 看出来）
        // 此时就可以返回 root;
        if (left != null && right != null) {
            return root;
        }
        // 情况 2 : 如果 p 和 q 都不在以 root 为根的树中，直接返回 null；
        if (left == null && right == null) {
            return null;
        }
        // 情况 3 ： 如果 p 和 q 只有一个存在 root 为根的树中，函数返回该节点
        return left == null ? right : left;
        // post--end
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor3(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor3(root.right, p, q);

        if (leftNode != null && rightNode != null) {
            return root;
        }

        if (leftNode == null && rightNode == null) {
            return null;
        }

        return leftNode == null ? rightNode : leftNode;

    }

    public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root  == q) return root;

        TreeNode leftNode = lowestCommonAncestor4(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor4(root.right, p, q);

        if (leftNode != null && rightNode != null) {
            return root;
        }

        if (leftNode == null && rightNode == null) {
            return null;
        }
        return leftNode == null ? rightNode : leftNode;
    }

    public TreeNode lowestCommonAncestor5(TreeNode root ,TreeNode p ,TreeNode q){
        if (root ==null) {
            return null;
        }
        if (p==root||q==root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor5(root.left,p,q);
        TreeNode right = lowestCommonAncestor5(root.right,p,q);
        if (left!=null&&right!=null) {
            return  root;
        }
        if(left==null&&right==null){
            return null;
        }
        return left==null ? right :left;



    }


}
