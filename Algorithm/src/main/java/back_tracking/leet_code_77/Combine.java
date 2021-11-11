package back_tracking.leet_code_77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/6 21:26
 * @Url : https://leetcode-cn.com/problems/combinations/
 * @Level :  easy  medium hard
 * @Desc :组合
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            System.out.println("递归之前 => " + path);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }

}
