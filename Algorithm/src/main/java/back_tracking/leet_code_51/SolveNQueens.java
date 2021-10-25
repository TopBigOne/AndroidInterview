package back_tracking.leet_code_51;

import java.util.*;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/24 23:12
 * @Url : https://leetcode-cn.com/problems/n-queens/
 * @Level :     hard
 * @Desc : N 皇后
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/n-queens/solution/gen-ju-di-46-ti-quan-pai-lie-de-hui-su-suan-fa-si-/
 * <p>
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */
public class SolveNQueens {
    private Set<Integer> col;
    private Set<Integer> main;
    private Set<Integer> sub;
    private int n;
    private List<List<String>> res;

    /**
     * 回溯搜索算法（深度优先遍历）
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        col = new HashSet<>();
        main = new HashSet<>();
        sub = new HashSet<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return res;
    }

    private void dfs(int row, Deque<Integer> path) {
        if (row == n) {
            List<String> board = convert2Board(path);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !main.contains(row - i) && !sub.contains(row + i)) {

                path.addLast(i);

                col.add(i);
                main.add(row - i);
                sub.add(row + i);

                dfs(row + 1, path);

                sub.remove(row + i);
                main.remove(row - i);
                col.remove(i);

                path.removeLast();
            }
        }
    }

    private List<String> convert2Board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            row.append(String.join("", Collections.nCopies(Math.max(0, n), ".")));
            row.replace(num, num + 1, "Q");
            board.add(row.toString());
        }
        return board;
    }
}
