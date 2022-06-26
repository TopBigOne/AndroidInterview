package tree.bst.leet_code_501;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tree.TreeNode;
import tree.TreeNodeFactory;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/19 22:56
 * @Desc :
 * 501. 二叉搜索树中的众数 https://leetcode.cn/problems/find-mode-in-binary-search-tree/
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 出现频率最高的元素；
 */
public class FindMode {
    public static void main(String[] args) {
        Integer[] raw = {1, 1, 1, 6};
        TreeNode root = TreeNodeFactory.build(raw);
        FindMode findMode = new FindMode();
        int[] result = findMode.findMode(root);
        System.err.println("result : " + Arrays.toString(result));
    }

    int maxTime = Integer.MIN_VALUE;
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 使用普通遍历的方式实现
     *
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        dfs(root);
        List<Integer> res = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxTime) {
                res.add(key);
            }
        }
        return res.stream().mapToInt(a -> a).toArray();
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        int val = root.val;
        map.put(val, map.getOrDefault(val, 0) + 1);
        maxTime = Integer.max(map.get(val), maxTime);
        System.err.println("maxTime : " + maxTime);

        dfs(root.right);
    }
}
