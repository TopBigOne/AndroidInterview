package tree.dfs.leet_code_508;

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
 * @Date :  2022/6/19 15:55
 * @Desc : 出现次数最多的子树元素和
 *
 * <p>
 * leet code 508 :https://leetcode.cn/problems/most-frequent-subtree-sum/solution/508-by-wan-jia-guo-du-xjmj/
 */
public class FindFrequentTreeSum {
    public static void main(String[] args) {
        FindFrequentTreeSum findFrequentTreeSum = new FindFrequentTreeSum();
        Integer[] nums = {5, 2, -3};
        TreeNode treeNode = TreeNodeFactory.build(nums);
        int[] result = findFrequentTreeSum.findFrequentTreeSum(treeNode);
        System.err.println("result ：" + Arrays.toString(result));
    }


    private int max = Integer.MIN_VALUE;

    /**
     * 其实就是求，有多少种子树的和；
     *
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        postDfs(root, map);
        List<Integer> res = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                res.add(key);
            }
        }
        return res.stream().mapToInt(a -> a).toArray();
    }

    private int postDfs(TreeNode root, Map<Integer, Integer> map) d{
        if (root == null) {
            return 0;
        }

        int leftValue = postDfs(root.left, map);
        int rightValue = postDfs(root.right, map);
        int sum = leftValue + rightValue + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.getOrDefault(sum, 0));
        return sum;
    }


}
