package array.leet_code_440;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/19 14:43
 * @Desc :
 */
public class FindKthNumber3 {

    public int findKthNumber(int n, int k) {
        int cur = 1;
        // 去掉第0个节点
        k = k - 1;
        while (k > 0) {
            int num = getNode(n, cur, cur + 1);
            if (num <= k) {
                cur += 1;
                k -= num;
            } else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }

    private int getNode(int n, long first, long last) {
        int num = 0;
        while (first <= n) {
            num += Math.min(n + 1, last) - first;
            first *= 10;
            last *= 10;
        }
        return num;
    }
}
