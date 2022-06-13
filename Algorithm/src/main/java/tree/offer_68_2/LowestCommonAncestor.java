package tree.offer_68_2;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/7 22:27 ： 这一天，下了一整天的雨，我从顺义医院回来以后，在北京的的地铁里，一边看书，
 * 地铁两次经过 阜成门，我在一边在思考着，要不要联系你....
 * https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @Url :
 * @Level :  easy
 * @Desc : 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果树为空，直接返回null；
        if (root == null) {
            return null;
        }
        // 如果p，q中有等于root的，那么它们的最近公共祖先就是root
        if (root == p || root == q) {
            return root;
        }
        // 递归遍历左子树，只要在左子树中找到p或者q，则先找到谁，就返回谁；
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //  递归遍历右子树，只要在右子树中找到p或者q ，则先找到谁，就返回谁；
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左子树中p和q都找到不到，则p和q一定都在右子树中，
        // 右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是他自己的祖先）
        if (left == null) {
            return right;
        } else if (right == null) {
            // left 不为空，在左子树中有找到节点(p或者q)，
            // 这个时候要在判断一下右子树中的情况，如果在右子树中，p，q都找不到，则p和q一定在左子树中，
            // 左子树中先遍历到的那个就是最近公共祖先
            return left;
        } else {
            // 当left和right均不为空，说明p，q 节点分别在root两侧，最近公共祖先，root；
            return root;
        }

    }
}
