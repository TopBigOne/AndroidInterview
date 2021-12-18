package array.leet_code_542_01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : dev
 * @version :
 * @Date :  12/18/21 10:38 PM
 * @Desc :  https://leetcode-cn.com/problems/01-matrix/solution/
 *
 * https://leetcode-cn.com/problems/01-matrix/solution/2chong-bfs-xiang-jie-dp-bi-xu-miao-dong-by-sweetie/
 */
public class UpdateMatrix {
    public int[][] updateMatrix(int[][] mat) {
        // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 mat[x][y] + 1。
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && mat[newX][newY] == -1) {
                    mat[newX][newY] = mat[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return mat;


    }


}
