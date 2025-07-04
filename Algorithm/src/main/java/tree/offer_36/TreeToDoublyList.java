package tree.offer_36;

import tree.Node;

/**
 * @author : dev
 * @version :
 * @Date :  8/3/21 11:17 PM
 * @Desc : offer  36：二叉搜索树与双向链表：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * <p>
 * 题解：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/
 */
public class TreeToDoublyList {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        TreeToDoublyList treeToDoublyList = new TreeToDoublyList();

        treeToDoublyList.treeToDoublyList(root);

    }

    private Node tail = null;
    private Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);

        // 首尾串起来
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }

        dfs(cur.left);

        if (tail == null) {
            head = cur;
        } else {
            tail.right = cur;
        }

        cur.left = tail;
        // tail 右移一位.
        tail = cur;

        dfs(cur.right);
    }


    private void dfs2(Node cur) {
        if (cur == null) {
            return;
        }

        dfs2(cur.left);

        if (tail == null) {
            head = cur;
        } else {
            tail.right = cur;
        }
        cur.left = tail;
        tail = cur;
        dfs2(cur.right);


    }


}
