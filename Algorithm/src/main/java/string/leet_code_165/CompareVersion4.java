package string.leet_code_165;

import com.sun.imageio.plugins.common.I18N;

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

public class CompareVersion4 {
    public static void main(String[] args) {
        String v1 = "1.01";
        String v2 = "1.001";

    }

    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        int len1 = str1.length;
        int len2 = str2.length;
        while (i < len1 || j < len2) {
            String s1 = i < len1 ? str1[i] : "0";
            String s2 = j < len2 ? str2[j] : "0";
            int res = compare(s1, s2);
            if (res == 0) {
                i++;
                j++;
                continue;
            }
            return res;
        }
        return 0;

    }

    private int compare(String s1, String s2) {
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        return Integer.compare(n1, n2);
    }


}
