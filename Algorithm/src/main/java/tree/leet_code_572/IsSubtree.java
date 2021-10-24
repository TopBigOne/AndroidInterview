package tree.leet_code_572;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/14 23:43
 * @Url :   https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @Level :  easy
 * @Desc :  你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
public class IsSubtree {
    static final int MAX_N = 1005;
    static final int MOD = 1000000007;
    boolean[] vis = new boolean[MAX_N];
    int[] p = new int[MAX_N];
    int tot;
    Map<TreeNode, int[]> hS = new HashMap<TreeNode, int[]>();
    Map<TreeNode, int[]> hT = new HashMap<TreeNode, int[]>();

    public boolean isSubtree(TreeNode s, TreeNode t) {
        getPrime();
        dfs(s, hS);
        dfs(t, hT);

        int tHash = hT.get(t)[0];
        for (Map.Entry<TreeNode, int[]> entry : hS.entrySet()) {
            if (entry.getValue()[0] == tHash) {
                return true;
            }
        }

        return false;
    }

    public void getPrime() {
        vis[0] = vis[1] = true;
        tot = 0;
        for (int i = 2; i < MAX_N; ++i) {
            if (!vis[i]) {
                p[++tot] = i;
            }
            for (int j = 1; j <= tot && i * p[j] < MAX_N; ++j) {
                vis[i * p[j]] = true;
                if (i % p[j] == 0) {
                    break;
                }
            }
        }
    }

    public void dfs(TreeNode o, Map<TreeNode, int[]> h) {
        h.put(o, new int[]{o.val, 1});
        if (o.left == null && o.right == null) {
            return;
        }
        if (o.left != null) {
            dfs(o.left, h);
            int[] val = h.get(o);
            val[1] += h.get(o.left)[1];
            val[0] = (int) ((val[0] + (31L * h.get(o.left)[0] * p[h.get(o.left)[1]]) % MOD) % MOD);
        }
        if (o.right != null) {
            dfs(o.right, h);
            int[] val = h.get(o);
            val[1] += h.get(o.right)[1];
            val[0] = (int) ((val[0] + (179L * h.get(o.right)[0] * p[h.get(o.right)[1]]) % MOD) % MOD);
        }
    }


}
