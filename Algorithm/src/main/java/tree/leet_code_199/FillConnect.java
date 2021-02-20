package tree.leet_code_199;

import java.util.Objects;

import tree.Node;

/**
 * @author : dev
 * @version :
 * @Date :  2/20/21 12:13 AM
 * @Desc :
 * 题解（https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/bfshe-di-gui-zui-hou-liang-chong-ji-bai-liao-100-2/）
 */
public class FillConnect {
    public Node connect(Node root) {
        if (root == null) return null;

        //cur我们可以把它看做是每一层的链表
        Node cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点（注意这里是访问
            //当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(0);
            //pre表示下一层节点的前一个节点
            Node pre = dummy;

            //然后开始遍历当前层的链表
            //因为是完美二叉树，如果有左子节点就一定有右子节点
            while (cur != null && cur.left != null) {
                //让pre节点的next指向当前节点的左子节点，也就是把它串起来
                pre.next = cur.left;
                //然后再更新pre
                pre = pre.next;

                //pre节点的next指向当前节点的右子节点，
                pre.next = cur.right;
                pre = pre.next;
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
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

    public Node connect3(Node root) {
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

    public Node connect4(Node root) {
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

    public Node connect5(Node root) {
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
