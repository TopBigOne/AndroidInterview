package stack.leet_code_85;

import java.io.Closeable;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : dev
 * @version :
 * @Date :  3/18/21 7:40 PM
 * @Desc :
 */
public class MaximalRectangle2 {
    public int maximalRectangle(char[][] matrix) {
        int rows;
        if (matrix == null || (rows = matrix.length) == 0) {
            return 0;
        }
        int cols = matrix[0].length;

        int[][] grid = new int[rows][cols];
        buildHistogram(matrix, grid);
        int max = 0;
        for (int i = 0; i < rows; i++) {
            max = Math.max(max, maxRec(grid, i));
        }
        return max;
    }

    public void buildHistogram(char[][] matrix, int[][] grid) {
        int cols = matrix[0].length;
        for (int j = 0; j < cols; j++) {
            grid[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        int rows = matrix.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = matrix[i][j] == '1' ? grid[i - 1][j] + 1 : 0;
            }
        }
    }

    private int maxRec(int[][] grid, int bottom) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0;
        int curIndex = 0;
        while (curIndex < grid[bottom].length) {
            while (stack.peek() != -1 && grid[bottom][curIndex] <= grid[bottom][stack.peek()]) {
                max = Math.max(max, grid[bottom][stack.pop()] * (curIndex - stack.peek() - 1));
            }
            stack.push(curIndex++);
        }
        while (stack.peek() != null && stack.peek() != -1) {
            max = Math.max(max, grid[bottom][stack.pop()] * (grid[bottom].length - stack.peek() - 1));
        }
        return max;
    }
}
