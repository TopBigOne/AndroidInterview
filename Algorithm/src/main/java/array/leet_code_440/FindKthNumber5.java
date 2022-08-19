package array.leet_code_440;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/19 15:29
 * @Desc :
 */
public class FindKthNumber5 {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k -= 1;
        while (k > 0) {
            int num = getNode(n, curr, curr + 1);
            if (num <= k) {
                curr += 1;
                k -= num;
            } else {
                curr *= 10;
                k--;
            }

        }
        return curr;

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
