package back_tracking.leet_code_52;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/24 23:47
 * @Url :https://leetcode-cn.com/problems/n-queens-ii/
 * @Level :     hard
 * @Desc :
 * @Counter :
 * @Answer :
 * <p>
 * https://leetcode-cn.com/problems/n-queens-ii/solution/jing-dian-hui-su-yi-dong-jie-fa-kan-bu-dong-ni-da-/
 */
public class TotalNQueens {
    int n;
    int[] res; //记录每种方案的皇后放置索引
    int count = 0; //总方案数

    public int totalNQueens(int n) {
        this.n = n;
        this.res = new int[n];
        check(0); // 第0行开始放置
        return count;
    }

    //放置第k行
    public void check(int k) {
        if (k == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            res[k] = i;  // 将位置i 放入索引数组第k个位置
            if (!judge(k)) {
                check(k + 1); //不冲突的话，回溯放置下一行
            }
            //冲突的话试下一个位置
        }
    }

    //判断第k行的放置是否与之前位置冲突
    public boolean judge(int k) {
        for (int i = 0; i < k; i++) {
            if (res[k] == res[i] || Math.abs(k - i) == Math.abs(res[k] - res[i])) {
                return true;
            }
        }
        return false;
    }

}
