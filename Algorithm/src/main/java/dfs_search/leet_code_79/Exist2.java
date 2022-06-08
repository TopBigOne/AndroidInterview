package dfs_search.leet_code_79;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/5 16:12
 * @Desc :
 */
public class Exist2 {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        Exist2 exist = new Exist2();
        boolean result = exist.exist(board, word);
        System.err.println("result : " + result);
    }


    public boolean exist(char[][] board, String word) {
        // corner base
        int rows = board.length;
        if (rows == 0) {
            return false;
        }
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, i, j, 0, visited, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int depth,
                        boolean[][] visited, String word) {
        System.err.println("depth : " + depth);
        if (depth == word.length() - 1) {

            return board[i][j] == word.charAt(depth);
        }

        if (board[i][j] == word.charAt(depth)) {
            visited[i][j] = true;

            // 左 ，下，右,上
            int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
            for (int[] direction : directions) {
                int newX = i + direction[0];
                int newY = j + direction[1];
                if (inArea(newX, newY, board.length, board[0].length) && !visited[newX][newY]) {
                    if (dfs(board, newX, newY, depth + 1, visited, word)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }


}
