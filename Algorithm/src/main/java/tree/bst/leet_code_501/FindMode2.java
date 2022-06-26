package tree.bst.leet_code_501;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tree.TreeNode;
import tree.TreeNodeFactory;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/19 23:50
 * @Desc :
 */
public class FindMode2 {

    public static void main(String[] args) {
        Integer[] raw = {1, 1, 1, 2, 2, 2, 6};
        TreeNode root = TreeNodeFactory.build(raw);
        FindMode2 findMode = new FindMode2();
        int[] result = findMode.findMode(root);
        System.err.println("result : " + Arrays.toString(result));
    }

    private final List<Integer> res = new ArrayList<>();
    private int dynamicCount = 0;
    private int maxCount = Integer.MIN_VALUE;
    private TreeNode prev = null;

    /**
     * 利用bst树的单调性
     *
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        dfs(root);
        return res.stream().mapToInt(a -> a).toArray();
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        // 遍历左子树
        dfs(root.left);

        // 当前节点的val和前一个几点的val相等
        // 就动态计算count；
        if (prev != null && root.val == prev.val) {
            dynamicCount++;
        } else {
            // 不想的，count 就为1，表示就出现了一次
            dynamicCount = 1;
        }

        // 开始统计
        if (dynamicCount == maxCount) {
            res.add(root.val);
        }
        // 清空以前所有的统计
        if (dynamicCount > maxCount) {
            maxCount = dynamicCount;
            // 清空以前所有的统计,因为出现了更大的count
            res.clear();
            res.add(root.val);
        }

        // 当前节点赋值给前一个节点，便于下一轮做比较
        prev = root;
        // 遍历右子树
        dfs(root.right);
    }
}
