package dfs_search.leet_code_79;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/3 20:54
 * @Desc :
 */
public class Exist4 {
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
        if (i < 0 || j < 0 || i >= board.length ||
                j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        int nextCharIndex = index + 1;
        boolean isFound =
                dfs(board, word, i + 1, j, nextCharIndex) ||
                        dfs(board, word, i - 1, j, nextCharIndex) ||
                        dfs(board, word, i, j + 1, nextCharIndex) ||
                        dfs(board, word, i, j - 1, nextCharIndex);

        board[i][j] = temp;

        return isFound;
    }
}
