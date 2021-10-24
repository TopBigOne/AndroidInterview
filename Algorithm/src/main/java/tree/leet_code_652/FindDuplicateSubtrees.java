package tree.leet_code_652;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/13 23:35
 * @Url : https://leetcode-cn.com/problems/find-duplicate-subtrees/
 * @Level :    medium
 * @Desc : 寻找重复的子树
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/find-duplicate-subtrees/solution/xun-zhao-zhong-fu-de-zi-shu-by-leetcode/
 */
public class FindDuplicateSubtrees {
    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap<>();
        count = new HashMap<>();
        ans = new ArrayList<>();
        lookup(root);
        return ans;
    }

    public int lookup(TreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return t++;
            }
        });
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2) {
            ans.add(node);
        }
        return uid;
    }

}
