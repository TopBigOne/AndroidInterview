package dp.leet_code_221;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/28 18:40
 * @Url :    leetcode-221:最大正方形 ：https://leetcode-cn.com/problems/maximal-square/
 * @Level :    medium
 * @Desc :   leetcode-221:最大正方形在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * @Counter :  9
 * @Answer : https://leetcode-cn.com/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/
 * <p>
 * <p>
 * 官方题解：https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
 */
public class MaximalSquare {
    // 含优化过程的代码
    public int maximalSquare(char[][] matrix) {
        // base condition
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        // 相当于已经预处理新增第一行、第一列均为0
//  int[][] dp = new int[height + 1][width + 1];
        int[] dp = new int[width + 1];

        int northwest = 0; // 西北角、左上角

//  for (int row = 0; row < height; row++) {
        for (char[] chars : matrix) {
            northwest = 0; // 遍历每行时，还原回辅助的原值0
            for (int col = 0; col < width; col++) {
                int nextNorthwest = dp[col + 1];
                if (chars[col] == '1') {
//              dp[row + 1][col + 1] = Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col]) + 1;

                    dp[col + 1] = Math.min(Math.min(dp[col], dp[col + 1]), northwest) + 1;
//              maxSide = Math.max(maxSide, dp[row + 1][col + 1]);
                    maxSide = Math.max(maxSide, dp[col + 1]);
                } else {
                    dp[col + 1] = 0;
                }
                northwest = nextNorthwest;
            }
        }
        return maxSide * maxSide;
    }

    public int maximalSquare2(char[][] matrix) {
        int height = 0;
        int width = 0;
        if (matrix == null || (height = matrix.length) < 1 || (width = matrix[0].length) < 1) {
            return 0;
        }
        int maxSide = 0;
        int[] dp = new int[width + 1];
        // 西北角，左上角
        int northWest = 0;
        // 行遍历：一行一行的遍历，第一层遍历得到是chars[] 数组，
        for (char[] chars : matrix) {
            // 遍历每行时，还原回辅助的原值0；
            northWest = 0;
            for (int col = 0; col < width; col++) {
                int nextNorthWest = dp[col + 1];
                char currChar = chars[col];
                if (currChar == '1') {
                    dp[col + 1] = Math.min(Math.min(dp[col], dp[col + 1]), northWest) + 1;
                    maxSide = Math.max(maxSide, dp[col + 1]);
                } else {
                    dp[col + 1] = 0;
                }
                northWest = nextNorthWest;
            }
        }
        return maxSide * maxSide;
    }

    public int maximalSquare3(char[][] matrix) {
        int height = 0;
        int width = 0;
        // 1: base corner
        if (matrix == null || (height = matrix.length) < 1 || (width = matrix[0].length) < 1)
            return 0;

        int maxSide = 0;
        int[] dp = new int[width + 1];
        // 西北角：左上角
        int northWest = 0;
        // 行遍历：一行一行的遍历，第一层遍历得到是chars[] 数组


        for (char[] chars : matrix) {
            northWest = 0;
            for (int col = 0; col < width; col++) {
                // 下一个结果
                int nextNorthWest = dp[col + 1];
                // 当前字符
                char currChar = chars[col];
                if (currChar == '1') {
                    dp[col + 1] = Math.min(Math.min(dp[col], dp[col + 1]), northWest) + 1;
                    maxSide = Math.max(maxSide, dp[col + 1]);
                } else {
                    dp[col + 1] = 0;
                }
                northWest = nextNorthWest;
            }
        }
        return maxSide * maxSide;
    }
}
