package stack.leet_code_145;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  3/7/21 8:13 PM
 * @Desc : 用栈实现二叉树的 后序遍历
 * 题解：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--34/
 */
public class PostOrderTraversalByStack {
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        while (root != null) {
            if (root.right == null) {
                list.add(root.val);
                root = root.left;
                continue;
            }

            TreeNode pre = root.right;
            while (pre.left != null && pre.left != root) {
                pre = pre.left;
            }
            if (pre.left == null) {
                list.add(root.val);
                pre.left = root;
                root = root.right;
            }
            if (pre.left == root) {
                pre.left = null; // 这里可以恢复为 null
                root = root.left;
            }
        }

        Collections.reverse(list);
        return list;

    }


    public List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.right == null) {
                list.add(cur.val);
                cur = cur.left;
                continue;
            }

            TreeNode pre = cur.right;
            while (pre.left != null && pre.left != cur) {
                pre = pre.left;
            }
            if (pre.left == null) {
                list.add(cur.val);
                pre.left = cur;
                cur = cur.right;
            }
            if (pre.left == cur) {
                pre.left = null; // 这里可以恢复为 null
                cur = cur.left;
            }

        }
        Collections.reverse(list);

        return list;
    }

    public List<Integer> postOrderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.right == null) {
                list.add(cur.val);
                cur = cur.left;
                continue;
            }
            TreeNode pre = cur.right;
            while (pre.left != null && pre.left != cur) {
                pre = pre.left;
            }
            if (pre.left == null) {
                list.add(cur.val);
                pre.left = cur;
                cur = cur.right;
            }
            if (pre.left == cur) {
                pre.left = null;
                cur = cur.left;
            }
        }
        Collections.reverse(list);
        return list;

    }

    public List<Integer> postOrderTraversal4(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.right == null) {
                list.add(cur.val);
                cur = cur.left;
                continue;
            }
            TreeNode pre = cur.right;
            while (pre.left != null && pre.left != cur) {
                pre = pre.left;
            }

            if (pre.left == null) {
                list.add(cur.val);
                pre.left = cur;
                cur = cur.right;
            }

            if (pre.left == cur) {
                pre.left = null;
                cur = cur.left;
            }
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> postOrderTraversal5(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.right == null) {
                list.add(cur.val);
                cur = cur.left;
                continue;
            }
            TreeNode pre = cur.right;
            while (pre.left != null && pre.left != cur) {
                pre = pre.left;
            }
            if (pre.left == null) {
                list.add(cur.val);
                pre.left = cur;
                cur = cur.right;

            }

            if (pre.left == cur) {
                pre.left = null;
                cur = cur.left;
            }
        }

        Collections.reverse(list);
        return list;
    }

    public List<Integer> postOrderTraversal6(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.right == null) {
                list.add(cur.val);
                cur = cur.left;
                continue;
            }
            TreeNode pre = cur.right;
            while (pre.left != null && pre.left != cur) {
                pre = pre.left;
            }

            if (pre.left == null) {
                list.add(cur.val);
                pre.left = cur;
                cur = cur.right;
            }

            if (pre.left == cur) {
                pre.left = null;
                cur = cur.left;
            }
        }
        Collections.reverse(list);
        return list;

    }

    public List<Integer> postOrderTraversal7(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.right == null) {
                list.add(cur.val);
                cur = cur.left;
                continue;
            }
            TreeNode pre = cur.right;
            while (pre.left != null && pre.left != cur) {
                pre = pre.left;
            }
            if (pre.left == null) {
                list.add(cur.val);
                pre.left = cur;
                cur = cur.right;
            }

            if (pre.left == cur) {
                pre.left = null;
                cur = cur.left;
            }
        }

        Collections.reverse(list);
        return list;
    }


    public List<Integer> postOrderTraversal8(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.right == null) {
                list.add(cur.val);
                cur = cur.left;
                continue;
            }
            TreeNode pre = cur.right;
            while (pre.left != null && pre.left != cur) {
                pre = pre.left;
            }

            if (pre.left == null) {
                list.add(cur.val);
                pre.left = cur;
                cur = cur.right;
            }
            if (pre.left == cur) {
                pre.left = null;
                cur = cur.left;
            }
        }
        Collections.reverse(list);
        return list;
    }


    public List<Integer> postOrderTraversal9(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.right == null) {
                list.add(cur.val);
                cur = cur.left;
                continue;
            }
            TreeNode pre = cur.right;
            while (pre.left != null && pre.left != cur) {
                pre = pre.left;
            }

            if (pre.left == null) {
                list.add(cur.val);
                pre.left = cur;
                cur = cur.right;
            }

            if (pre.left == cur) {
                pre.left = null;
                cur = cur.left;
            }
        }

        Collections.reverse(list);

        return list;
    }


    public List<Integer> postOrderTraversal10(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.right == null) {
                list.add(curr.val);
                curr = curr.left;
                continue;
            }

            TreeNode pre = curr.right;
            while (pre.left != null && pre.left != curr) {
                pre = pre.left;
            }

            if (pre.left == null) {
                list.add(curr.val);
                pre.left = curr;
                curr = curr.right;
            }

            if (pre.left == curr) {
                pre.left = null;
                curr = curr.left;
            }
        }

        Collections.reverse(list);
        return list;
    }

    public List<Integer> postOrderTraversal11(TreeNode node) {
        List<Integer> result = new ArrayList<>(16);
        while (node != null) {
            if (node.right == null) {
                result.add(node.val);
                node = node.left;
                continue;
            }

            TreeNode pre = node.right;
            while (pre.left != null && pre.left != node) {
                pre = pre.left;
            }
            if (pre.left == null) {
                result.add(node.val);
                pre.left = node;
                node = node.right;
            }
            if (pre.left == node) {
                pre.left = null;
                node = node.left;
            }
        }

        Collections.reverse(result);
        return result;

    }
}

































