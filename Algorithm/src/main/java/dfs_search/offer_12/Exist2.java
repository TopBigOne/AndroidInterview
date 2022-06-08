package dfs_search.offer_12;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/5 17:26
 * @Desc :
 */
public class Exist2 {

    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] board, String word, int i, int j, int depth, boolean[][] visited) {
        char currChar = board[i][j];
        if (depth == word.length() - 1) {
            return currChar == word.charAt(depth);
        }
        if (currChar != word.charAt(depth)) {
            return false;
        }

        visited[i][j] = true;
        int[][] directions = new int[][]{
                {-1, 0},
                {0, 1},
                {0, -1},
                {1, 0},

        };
        for (int[] direction : directions) {
            int newX = direction[0] + i;
            int newY = direction[1] + j;
            boolean isInBounds = newX >= 0 && newX < board.length
                    && newY >= 0 && newY < board[0].length;
            if (isInBounds && !visited[newX][newY]) {
                if (dfs(board, word, newX, newY, depth + 1, visited)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }


}
