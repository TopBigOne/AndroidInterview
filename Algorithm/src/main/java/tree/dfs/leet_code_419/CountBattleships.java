package tree.dfs.leet_code_419;

import jdk.internal.org.objectweb.asm.tree.AbstractInsnNode;

/**
 * @author : dev
 * @version :
 * @Date :  12/18/21 9:48 PM
 * @Desc : 甲板上的战舰 : https://leetcode-cn.com/problems/battleships-in-a-board/solution/
 * <p>
 * 题解：https://leetcode-cn.com/problems/battleships-in-a-board/solution/gong-shui-san-xie-ji-chong-sao-miao-xian-trmc/
 */
public class CountBattleships {
    public int countBattleships(char[][] board) {
        char x = 'X';
        int m = board.length;
        int n = board[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && board[i - 1][j] == x) {
                    continue;
                }

                if (j > 0 && board[i][j - 1] == x) {
                    continue;
                }

                if (board[i][j] == x) {
                    ans++;
                }
            }
        }

        return ans;


    }

    public int countBattleships2(char[][] board) {
        int m = board.length, n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                if (board[i][j] == 'X') ans++;
            }
        }
        return ans;
    }

    public int countBattleships3(char[][] board) {
        char x = 'X';
        int m = board.length;
        int n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && board[i - 1][j] == x) {
                    continue;
                }
                if (j > 0 && board[i][j - 1] == x) {
                    continue;
                }
                if (board[i][j] == x) {
                    ans++;
                }

            }
        }

        return ans;
    }

}