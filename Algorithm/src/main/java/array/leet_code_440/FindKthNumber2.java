package array.leet_code_440;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/4 18:24
 * @Url : https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
 * @Level :  hard
 * @Desc : 字典序的第k小数字
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/solution/yi-tu-sheng-qian-yan-by-pianpianboy/
 */
public class FindKthNumber2 {

    public int findKthNumber(int n, int k) {
        int cur = 1;
        // 扣掉第0个节点
        k = k - 1;
        while (k > 0) {
            int num = getNode(n, cur, cur + 1);
            if (num <= k) {
                // 第k个数不在以cur为根节点的树上
                cur += 1;
                // cur 在字典序数组中 从左  往右移动
                k -= num;

            } else {
                // cur 在字典序数组中，从上  往下移动
                cur *= 10;
                // 抛出根节点
                k--;

            }
        }
        return cur;
    }

    public int getNode(int n, long first, long last) {
        int num = 0;
        while (first <= n) {
            // 比如n是195的情况，195 到 100 有96个数
            num += Math.min(n + 1, last) - first;
            // 访问下一层
            first *= 10;
            last *= 10;
        }
        return num;
    }


}
