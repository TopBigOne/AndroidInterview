package string.leet_code_165;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 17:24
 * @Desc : 165. 比较版本号  https://leetcode-cn.com/problems/compare-version-numbers/
 */
public class CompareVersion6 {
    public int compareVersion(String version1, String version2) {
        int m = version1.length();
        int n = version2.length();
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            int num1 = 0;
            int num2 = 0;
            while (i < m && version1.charAt(i) != '.') {
                num1 = num1 * 10 + version1.charAt(i) - '0';
                i++;
            }
            while (j < n && version2.charAt(j) != '.') {
                num2 = num2 * 10 + version2.charAt(j) - '0';
                j++;
            }
            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;


    }
}
