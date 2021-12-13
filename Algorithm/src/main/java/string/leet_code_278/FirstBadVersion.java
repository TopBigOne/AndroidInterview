package string.leet_code_278;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/10 22:37
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/first-bad-version/solution/gong-shui-san-xie-shi-yong-jiao-hu-han-s-8hpv/
 */
public class FirstBadVersion extends VersionControl {
    public static void main(String[] args) {
        int n = 5;
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        int result = firstBadVersion.firstBadVersion(5);
        System.out.println("result : " + result);

    }

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            long temp = (long) l + r >> 1;
            int mid = (int) temp;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                // 不断的往右边移动
                l = mid + 1;
            }
        }
        return r;

    }

    public int firstBadVersion2(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            long temp = (long) l + r >>> 1;
            int mid = (int) temp;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;

    }

    public int firstBadVersion3(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            long temp = (long) l + r >>> 1;
            int mid = (int) temp;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;

    }

}
