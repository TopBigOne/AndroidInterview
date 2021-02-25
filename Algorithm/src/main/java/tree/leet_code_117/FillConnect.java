package tree.leet_code_117;

import jdk.nashorn.internal.objects.NativeNumber;
import tree.Node;

/**
 * @author : dev
 * @version :
 * @Date :  2/22/21 8:21 PM
 * @Desc : 填充每个节点的下一个右节点指针 2（https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/）
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 */
public class FillConnect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node cur = root;
        while (cur != null) {
            Node dummy = new Node(0);
            Node pre = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
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
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
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
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
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
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }

                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }

            cur = dummy.next;
        }

        return root;
    }


    public Node conect5(Node root) {
        if (root == null) {
            return null;
        }
        Node curr = root;
        while (curr != null) {
            Node dummy = new Node(0);
            Node pre = dummy;
            while (curr != null) {
                if (curr.left != null) {
                    pre.next = curr.left;
                    pre = pre.next;
                }

                if (curr.right != null) {
                    pre.next = curr.right;
                    pre = pre.next;
                }

                curr = curr.next;

            }
            curr = dummy.next;
        }

        return root;
    }


    public Node connect6(Node root) {
        if (root == null) {
            return null;
        }

        Node curr = root;
        while (curr != null) {
            Node dummy = new Node(0);
            Node pre = dummy;
            while (curr != null) {
                if (curr.left != null) {
                    pre.next = curr.left;
                    pre = pre.next;
                }

                if (curr.right != null) {
                    pre.next = curr.right;
                    pre = pre.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }


}
