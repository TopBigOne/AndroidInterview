package dfs_search.leet_code_79;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/3 20:37
 * @Desc :
 */
public class Exist3 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        // 边界条件
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        // 已经使用过 或者，不符合条件的字符
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        // 使用
        char temp = board[i][j];
        board[i][j] = '*';
        int nextIndex = index + 1;
        boolean isFound =
                dfs(board, word, i + 1, j, nextIndex) ||
                        dfs(board, word, i - 1, j, nextIndex) ||
                        dfs(board, word, i, j + 1, nextIndex) ||
                        dfs(board, word, i, j - 1, nextIndex);

        // 回溯
        board[i][j] = temp;
        return isFound;
    }
}
