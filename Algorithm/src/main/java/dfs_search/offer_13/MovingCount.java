package dfs_search.offer_13;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/5 19:16
 * @Desc :
 */
public class MovingCount {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int ans = 1;
        visited[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;
                }
                // 左边
                if (i - 1 >= 0) {
                    visited[i][j] = visited[i - 1][j];
                }
                //上面
                if (j - 1 >= 0) {
                    visited[i][j] = visited[i][j - 1];
                }
                ans += visited[i][j] ? 1 : 0;

            }
        }
        return ans;
    }

    public int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
