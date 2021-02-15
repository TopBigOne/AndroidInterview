package tree.leet_code_450;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/13/21 7:04 PM
 * @Desc : https://leetcode-cn.com/problems/delete-node-in-a-bst/solution/450-shan-chu-er-cha-sou-suo-shu-zhong-de-jie-dia-6/
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);

        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            //  XYLog.d(root.right);
        } else {
            int currRootValue = root.val;
            // 当前节点等于key，则需要删除当前节点，并保证二叉树的性质不变
            if (root.left == null) {
                // 当前节点没有左子树
                return root.right;
            }
            // 当前节点没有右子树
            if (root.right == null) {
                return root.left;
            }

            // 当前节点，左右子树都有
            TreeNode node = root.right;
            // 找到当前节点右子树中，最左边的叶子节点
            while (node.left != null) {
                node = node.left;
            }
            // 将 root 的整个左子树放到 root 右子树 中，最左边（最小）子树的下面
            node.left = root.left;
            return root.right;
        }


        return root;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            node.left = root.left;
            return root.right;
        }
        return root;
    }


    public TreeNode deleteNode3(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            node.left = root.left;
            return root.right;
        }
        return root;

    }

    public TreeNode deleteNode4(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        int rootValue = root.val;
        if (key < rootValue) {
            root.left = deleteNode(root.left, key);
        } else if (key > rootValue) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 左右子树不为空
            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            node.left = root.left;
            return root.right;
        }

        return root;
    }

    public TreeNode deleteNode5(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            node.left = root.left;
            return root.right;
        }

        return root;
    }

    public TreeNode deleteNode6(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            node.left = root.left;
            return root.right;
        }

        return root;
    }

    public TreeNode deleteNode7(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            node.left = root.left;
            return root.right;

        }

        return root;

    }

    public TreeNode deleteTreeNode8(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            node.left = root.left;
            return root.right;
        }

        return root;

    }


}
