package dfs_search.leet_code_79;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/11 17:35
 * @Desc :
 */
public class Exist5 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (word.length() == index) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        int nextIndex = index + 1;
        boolean isFound = dfs(board, i + 1, j, word, nextIndex)
                || dfs(board, i - 1, j, word, nextIndex)
                || dfs(board, i, j + 1, word, nextIndex)
                || dfs(board, i, j - 1, word, nextIndex);

        board[i][j] = temp;
        return isFound;
    }
}
