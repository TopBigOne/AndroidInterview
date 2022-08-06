package tree.offer_36;

import tree.Node;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/6 23:31
 * @Desc :
 */
public class TreeToDoublyList4 {

    Node head = null;
    Node tail = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void dfs(Node curr) {
        if (curr == null) {
            return;
        }
        dfs(curr.left);
        if (tail == null) {
            head = curr;
        } else {
            tail.right = curr;
        }
        curr.left = tail;
        tail = curr;

        dfs(curr.right);
    }


}
