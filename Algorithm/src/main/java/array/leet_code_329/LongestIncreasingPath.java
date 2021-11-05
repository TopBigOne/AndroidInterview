package array.leet_code_329;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/31 21:55
 * @Url : https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 * @Level :     hard
 * @Desc : 矩阵中的最长递增路径
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/solution/tong-ge-lai-shua-ti-la-yi-ti-si-jie-bfs-agawl/
 */
public class LongestIncreasingPath {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        // 从每一个点出发，往下深搜，看它最远能到哪儿
        int m = matrix.length;
        int n = matrix[0].length;

        // 记忆化
        int[][] memo = new int[m][n];

        // 每个点都要作为起始点遍历一下
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 已经遍历过的即不用遍历了
                if (memo[i][j] == 0) {
                    ans = Math.max(ans, dfs(matrix, m, n, i, j, memo));
                }
                // 这里为什么不用再比较一次ans 和 memo[i][j] 呢？
                // 因为遍历前面界面的时候，已经把后面的节点遍历了
                // 说明后面的节点肯定比前面的节点的最长 短路径 短
                // 所以,不用多判断一次了
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int m, int n, int i, int j, int[][] memo) {
        // 已经遍历过，直接返回
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        // 否则，看四个方向是否有满足条件的节点去扩散
        // 每个节点的初始路径为1
        int ans = 1;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI >= 0 && nextJ >= 0 && nextI < m && nextJ < n && matrix[nextI][nextJ] > matrix[i][j]) {
                ans = Math.max(ans, dfs(matrix, m, n, nextI, nextJ, memo) + 1);
            }
        }
        // 记录到缓存中
        memo[i][j] = ans;
        return ans;

    }
}
