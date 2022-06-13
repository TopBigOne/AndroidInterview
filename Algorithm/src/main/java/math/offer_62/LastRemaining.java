package math.offer_62;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/11 13:30
 * @Desc :
 * <p>
 * 推导：https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/si-bu-he-xin-gong-shi-qing-song-nong-don-3vln/
 */
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        int pos = 0; // 最终活下来那个人的初始位置
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i;  // 每次循环右移
        }
        return pos;
    }

    public int lastRemaining2(int n, int m) {
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i;
        }
        return pos;
    }

    public int lastRemaining3(int n, int m) {
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i;
        }
        return pos;
    }

    public int lastRemaining4(int n, int m) {
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i;
        }
        return pos;
    }
}
