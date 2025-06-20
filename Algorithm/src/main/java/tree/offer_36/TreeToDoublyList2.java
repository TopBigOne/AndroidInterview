package tree.offer_36;

import tree.Node;

/**
 * @author : dev
 * @version :
 * @Date :  8/4/21 1:08 AM
 * @Desc : 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class TreeToDoublyList2 {


    private Node pre;
    private Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        dfs(root);
        head.left = pre;
        pre.right = head;

        return head;

    }

    private void dfs(Node curr) {
        if (curr == null) {
            return;
        }
        dfs(curr.left);

        if (pre == null) {
            head = curr;
        } else {
            pre.right = curr;
        }

        curr.left = pre;
        pre = curr;

        dfs(curr.right);
    }


}
