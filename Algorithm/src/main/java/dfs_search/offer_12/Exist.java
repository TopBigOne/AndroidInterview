package dfs_search.offer_12;

/**
 * @author : dev
 * @version : 矩阵中的路径：https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * @Date :  2022/6/5 15:33
 * @Desc :
 */
public class Exist {
    public boolean exist(char[][] board, String word) {

        int r = board.length;
        int c = board[0].length;
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                boolean result = dfs(board, word, i, j, 0, visited);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int depth, boolean[][] visited) {
        char currChar = board[i][j];
        // 递归结束
        if (depth == word.length() - 1) {
            return currChar == word.charAt(depth);

        }
        if (currChar == word.charAt(depth)) {
            visited[i][j] = true;

            int[][] directions = {
                    {-1, 0},
                    {0, -1},
                    {0, 1},
                    {1, 0},
            };

            for (int[] direction : directions) {
                int newX = direction[0] + i;
                int newY = direction[1] + j;

                if (inArea(newX, newY, board.length, board[0].length) && !visited[newX][newY]) {
                    if (dfs(board, word, newX, newY, depth + 1, visited)) {
                        return true;
                    }
                }
            }
            //  回溯
            visited[i][j] = false;
        }

        return false;
    }

    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }


}
