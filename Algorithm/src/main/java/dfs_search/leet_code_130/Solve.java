package dfs_search.leet_code_130;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/15 15:28
 * @Desc :   130. 被围绕的区域  https://leetcode.cn/problems/surrounded-regions/
 * <p>
 * <p>
 * <p>
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的'O' 用 'X' 填充。
 * 题解：https://www.bilibili.com/video/BV1a4411q7WX?spm_id_from=333.337.search-card.all.click&vd_source=48ebba24d97534cb7fc891ea4972fffa
 */
public class Solve {

    public static void main(String[] args) {
        String[][] board = {
                {"X", "X", "X", "X"},
                {"X", "O", "O", "X"},
                {"X", "X", "O", "X"},
                {"X", "O", "X", "X"}
        };

        String[][] result = {
                {"X", "X", "X", "X"},
                {"X", "X", "X", "X"},
                {"X", "X", "X", "X"},
                {"X", "O", "X", "X"}
        };
    }


    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 是否在边界上
                boolean isInEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                // 只要把边界上的 OO 特殊处理了，
                if (isInEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[i][j] == 'O')) {
                    board[i][j] = 'X';
                }
                // 恢复成原来的样子
                if ((board[i][j] == '*')) {
                    board[i][j] = 'O';
                }
            }
        }

    }

    /**
     * 在边界上做dfs 搜索
     *
     * @param board
     * @param i
     * @param j
     */
    private void dfs(char[][] board, int i, int j) {
        // 边界
        if (i < 0 ||
                j < 0 ||
                i >= board.length ||
                j >= board[0].length) {
            return;
        }

        // 已经不是'O'了，可以over遍历了；
        if (board[i][j] == 'X') {
            return;
        }
        if (board[i][j] == '*') {
            return;
        }

        //将当前位置从 O 变成 *，做一下标记；
        board[i][j] = '*';

        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

}
