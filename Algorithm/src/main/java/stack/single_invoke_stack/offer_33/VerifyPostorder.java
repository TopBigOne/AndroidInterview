package stack.single_invoke_stack.offer_33;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/19 18:16
 * @Url :   https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @Level :    medium
 * @Desc : 二叉搜索树的后序遍历序列：  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，
 * 否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * @Counter :   4
 * @Answer : https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
 * https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/55ja2j/
 */
public class VerifyPostorder {
    /**
     * 递归解法
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    /**
     * @param postorder 原数组
     * @param i
     * @param j
     * @return
     */
    private boolean recur(int[] postorder, int i, int j) {
        // 此子树节点数量<=1; 无需要判别正确性；同时，这也是递归的终止的条件；
        if (i >= j) {
            return true;
        }
        // 左右子树的分割点
        int splitPoint = i;
        // 遍历，当找到一个值  postorder[splitPoint]  大于 postorder[j]时，分割点splitPoint 就找到了；
        while (postorder[splitPoint] < postorder[j]) {
            splitPoint++;
        }
        // m: 第一个大于根节点的节点
        int m = splitPoint;
        while (postorder[splitPoint] > postorder[j]) {
            splitPoint++;
        }
        // p ==j : 判断此树是否正确，是否为二叉搜索树；
        // recur(postorder, i, m - 1) : 左子树是否正确；
        // recur(postorder, i, j - 1) ：右子树是否正确；
        return splitPoint == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }


    private boolean recur2(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        // 左右子树的分割点
        int splitPoint = i;
        // 求分割点
        while (postorder[splitPoint] < postorder[j]) {
            splitPoint++;
        }
        // m: 是第一个大于根节点的 节点位置；
        int m = splitPoint;
        // 找到第一个小于postorder[j] 的点splitPoint
        while (postorder[splitPoint] > postorder[j]) {
            splitPoint++;
        }

        return splitPoint == j && recur2(postorder, i, m - 1) && recur2(postorder, m, j - 1);

    }

    private boolean recursive(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int splitIndex = i;
        while (postorder[splitIndex] < postorder[j]) {
            splitIndex++;
        }

        int m = splitIndex;
        while (postorder[splitIndex] > postorder[j]) {
            splitIndex++;
        }
        return splitIndex == j && recursive(postorder, i, m - 1) && recursive(postorder, m, j - 1);
    }


}
