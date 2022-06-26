package tree.bst;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  4/18/21 11:09 PM
 * @Desc : 根据二叉搜索树的后序遍历，构造出这颗二叉树，，，，
 */
public class PostOrder2BST {
    public TreeNode posArrayToBST1(int[] posArr) {
        // 0~N~1
        return process1(posArr, 0, posArr.length - 1);
    }

    /**
     * 目前，我们在使用 posArr[L...R]这些数字，来建树
     * 建出的每一个节点都连号，然后把整颗树的节点返回
     *
     * @param posArr
     * @param L
     * @param R
     * @return
     */
    private TreeNode process1(int[] posArr, int L, int R) {
        // 我们建树的范围就是：L-> R,当 L>R的时候，条件就不成立，就没法建树了。
        if (L > R) {
            return null;
        }
        // L<=R ,条件成立
        // 用数组最后一个元素建立头结点
        TreeNode head = new TreeNode(posArr[R]);
        if (L == R) {
            return head;
        }

        // L<R
        // 从 L-> R-1 上找到
        // 这是切分点
        int M = L - 1;
        for (int i = L; i < R; i++) {
            // 数组，从左到右，一直找，找到最后一个数，这个是一个，比根节点 posArr[R] 小的数，此时就是切分点
            if (posArr[i] < posArr[R]) {
                M = i;
            }
        }
        // L-M,就是建立左树的范围
        head.left = process1(posArr, L, M);
        // [M+1,R-1]这个就是建立右树的范围
        head.right = process1(posArr, M + 1, R - 1);
        return head;
    }
}
