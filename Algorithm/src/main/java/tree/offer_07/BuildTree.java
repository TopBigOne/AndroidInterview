package tree.offer_07;

import java.util.HashMap;
import java.util.Map;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  4/14/21 10:57 PM
 * @Desc : 重建二叉树 和 leet——105 ，是一样的结果！
 *
 * 题解：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
 *
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/4chong-jie-fa-di-gui-zhan-dui-lie-by-sdwwld/
 */
public class BuildTree {
    int[] preorder;
    private Map<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        // 建立根节点
        TreeNode node = new TreeNode(preorder[root]);
        // 划分根节点，左子树，右子树
        int i = dic.get(preorder[root]);
        // 开启左子树递归
        node.left = recur(root + 1, left, i - 1);
        // 开启右子树递归
        node.right = recur(root + i - left + 1, i + 1, right);
        // 回溯返回根节点
        return node;
    }






}
