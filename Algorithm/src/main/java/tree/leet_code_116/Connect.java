package tree.leet_code_116;

import tree.Node;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/17 23:34
 * @Url : https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/dong-hua-yan-shi-san-chong-shi-xian-116-tian-chong/
 */
public class Connect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node cur = root;
        while (cur != null) {
            Node dummy = new Node(0);
            Node pre = dummy;
            while (cur != null && cur.left != null) {
                pre.next = cur.left;
                pre = pre.next;
                pre.next = cur.right;
                pre = pre.next;
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;

    }

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node(0);
            Node pre = dummy;
            while (cur != null && cur.left != null) {
                pre.next = cur.left;
                pre = pre.next;
                pre.next = cur.right;
                pre = pre.next;
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;

    }
}
