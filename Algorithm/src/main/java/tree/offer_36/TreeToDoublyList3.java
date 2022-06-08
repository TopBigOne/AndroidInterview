package tree.offer_36;

import tree.Node;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/6 20:14
 * @Desc :
 * <p>
 * NOTE :二叉搜索树的中序遍历为 递增序列 。
 */
public class TreeToDoublyList3 {

    private Node pre;
    private Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);

        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);

        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }

        cur.left = pre;

        pre = cur;

        dfs(cur.right);
    }


}
