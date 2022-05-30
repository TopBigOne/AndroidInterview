package tree.offer_27;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/29 17:41
 * @Desc :
 */
public class MirrorTree2 {
    /**
     * 获取一颗树的镜像树
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode theFinalLeft = mirrorTree(root.right);
        TreeNode theFinalRight = mirrorTree(root.right);
        root.left = theFinalLeft;
        root.right = theFinalRight;
        return root;
    }
}
