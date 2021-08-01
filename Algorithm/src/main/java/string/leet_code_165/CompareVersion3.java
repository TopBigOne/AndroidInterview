package string.leet_code_165;

/**
 * @author :  dev
 * @version :
 * @Date :7/31/21 5:51 PM
 * @Url :  165. 比较版本号  https://leetcode-cn.com/problems/compare-version-numbers/
 * @Level :  medium
 * @Desc :  大于返回 1，小于返回-1，其他情况返回 0；
 * @Counter :  11
 * @Answer : https://leetcode-cn.com/problems/compare-version-numbers/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-40/
 */

public class CompareVersion3 {
    public static void main(String[] args) {
        String v1 = "1.01";
        String v2 = "1.001";


    }

    public int compareVersion(String version1, String version2) {
        // . 在 java 语言里组要做一下转义
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < nums1.length || j < nums2.length) {
            String str1 = i < nums1.length ? nums1[i] : "0";
            String str2 = j < nums2.length ? nums2[j] : "0";
            int res = compare(str1, str2);
            if (res == 0) {
                i++;
                j++;
                continue;
            }
            return res;
        }

        return 0;
    }

    private int compare(String str1, String str2) {
        int n1 = Integer.parseInt(str1);
        int n2 = Integer.parseInt(str2);
        return Integer.compare(n1, n2);
    }


}
