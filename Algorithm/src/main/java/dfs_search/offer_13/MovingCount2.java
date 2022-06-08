package dfs_search.offer_13;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/5 19:28
 * @Desc :
 */
public class MovingCount2 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n || digitSum(i) + digitSum(j) > k ||
                visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int left = dfs(i - 1, j, m, n, k, visited);
        int right = dfs(i + 1, j, m, n, k, visited);
        int top = dfs(i, j - 1, m, n, k, visited);
        int bottom = dfs(i, j + 1, m, n, k, visited);
        return 1 + left + top + right + bottom;
    }

    private int digitSum(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
