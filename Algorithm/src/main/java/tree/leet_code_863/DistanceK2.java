package tree.leet_code_863;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/3 21:40
 * @Url :
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/solution/gai-bian-shu-de-xing-zhuang-c-si-lu-dai-ma-by-lhrs/
 */
public class DistanceK2 {
    List<Integer> result = new ArrayList<>();
    // ne存储目标节点的爸爸
    TreeNode ne;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 首先把树分为两棵，一棵以目标节点为根，一棵以目标节点爸爸为根
        dfs(root, target, null);
        // 搜索以目标节点为根的树深度为k的节点
        collect(target, 0, k);
        // 搜索以目标节点爸爸为根的树深度为k-1的节点
        collect(ne, 0, k - 1);
        return result;
    }

    public Boolean dfs(TreeNode root, TreeNode target, TreeNode father) {
        if (root == null) {
            return false;
        }
        // 如果搜到了目标节点，那么它爸爸就是新树的根
        if (root == target) {
            ne = father;
            // 递归的时候返回：我们解除父子关系
            return true;
        }
        // 如果我成了左儿子的儿子，那我的爸爸就是我的新的左儿子
        if (dfs(root.left, target, root)) {
            root.left = father;
            // 递归的时候：我是你爸爸
            return true;
        }
        // 如果我成了我右儿子的儿子，那我的爸爸就是我的新的右儿子
        if (dfs(root.right, target, root)) {
            root.right = father;
            return true;
        }
        // 递归的时候返回：爸爸
        return false;
    }

    // 搜索以k为根节点的树的第k层所有节点，随便拿dfs写的，这里也可以层序遍历
    public void collect(TreeNode root, int n, int k) {
        if (root == null) {
            return;
        }
        // 如果达到指定搜索深度，返回搜寻结果
        if (n == k) {
            result.add(root.val);
        } else {
            collect(root.left, n + 1, k);
            collect(root.right, n + 1, k);
        }
    }

}
