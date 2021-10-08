package tree.leet_code_863;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/3 21:08
 * @Url : https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 * @Level :    medium
 * @Desc : 二叉树中所有距离为k的结点
 * @Counter : 2
 * @Answer : https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/solution/gong-shui-san-xie-yi-ti-shuang-jie-jian-x6hak/
 */
public class DistanceK {
    // 根据数据范围最多有501个点，每个点最多有两个无向边（两个子节点）
    int N = 510;
    int M = N * 4;
    int[] he = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int idx;
    boolean[] vis = new boolean[N];

    /**
     * 时间复杂度： 通过DFS 进行建图，复杂度O(n),通过迭代加深找到距离target 为k的节点，
     * 复杂度O(n). 整体复杂度O(n)
     * 空间复杂度：因为是二叉树，边数与总数是呈现线性关系，复杂度O(n)
     *
     * @param root
     * @param t
     * @param k
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode t, int k) {
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(he, -1);
        dfs(root);
        vis[t.val] = true;
        find(t.val, k, 0, ans);
        return ans;

    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs(root.left);
        }
        if (root.right != null) {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs(root.right);
        }

    }

    private void find(Integer root, int max, int cur, List<Integer> ans) {
        if (cur == max) {
            ans.add(root);
            return;
        }
        for (int i = he[root]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!vis[j]) {
                vis[j] = true;
                find(j, max, cur + 1, ans);
            }
        }
    }

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }


}
