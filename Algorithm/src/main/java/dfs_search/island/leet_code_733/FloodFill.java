package dfs_search.island.leet_code_733;

/**
 * @author : dev
 * @version :
 * @Date :  12/16/21 9:34 PM
 * @Desc :
 * <p>
 * <p>
 * <p>
 * 题解：https://leetcode-cn.com/problems/flood-fill/solution/zhe-chong-ti-du-you-kuang-jia-de-nei-fu-xiang-jie-/
 */
public class FloodFill {
    //定义visited数组，判断是否访问
    boolean[][] visited;
    //方向数组
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //visited数组初始化（之所以在函数外面声明数组，是为了在dfs函数中少传参数）
        visited = new boolean[image.length][image[0].length];
        //旧color值
        int color = image[sr][sc];
        //开始dfs
        dfs(image, sr, sc, newColor, color);

        //返回结果
        return image;
    }

    public void dfs(int[][] image, int row, int col, int newColor, int color) {
        //以下情况直接终止搜索
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || visited[row][col]) {
            return;
        }

        //遇到相同颜色，就染色，否则，终止搜索，防止跨过当前不符合条件的点
        if (image[row][col] == color) {
            image[row][col] = newColor;
            visited[row][col] = true;
        } else {
            return;
        }

        //四个方向的递归搜索
        dfs(image, row + 1, col, newColor, color);
        dfs(image, row, col + 1, newColor, color);
        dfs(image, row - 1, col, newColor, color);
        dfs(image, row, col - 1, newColor, color);

    }


}
