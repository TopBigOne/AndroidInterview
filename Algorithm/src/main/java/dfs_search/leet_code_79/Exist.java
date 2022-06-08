package dfs_search.leet_code_79;

/**
 * @author : dev
 * @version :
 * @Date :  6/10/21 11:54 PM
 * @Desc :
 * <p>
 * <p>
 * <p>
 * 题解：https://leetcode-cn.com/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/
 */
public class Exist {


    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        if (rows == 0) {
            return false;
        }
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i,
                        int j, int depth,
                        boolean[][] visited) {


        if (depth == word.length() - 1) {
            return board[i][j] == word.charAt(depth);
        }

        int[][] DIRECTIONS = {
                {-1, 0},
                {0, -1},
                {0, 1},
                {1, 0}
        };
        if (board[i][j] == word.charAt(depth)) {
            visited[i][j] = true;
            // 四个方向不断的探索
            for (int[] direction : DIRECTIONS) {
                int newX = i + direction[0];
                int newY = j + direction[1];
                // condition one
                boolean isInArea = inArea(newX, newY, board.length, board[0].length);
                // condition two
                boolean isVisited = visited[newX][newY];
                if (isInArea && !isVisited) {
                    if (dfs(board, word, newX, newY, depth + 1, visited)) {
                        return true;
                    }
                }
            }

            visited[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }


}
